package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.impl.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;

public class TransactionHandlerImpl implements TransactionHandler {

    @Override
    public TransactionStrategy makeTransaction(FruitTransaction transaction) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance couldn't be less '0'.\n"
                    + " Invalid data received from input file: balance "
                    + transaction.getFruitName() + " = " + transaction.getQuantity());
        }
        fruitsDao.storageAccess().put(transaction.getFruitName(), transaction.getQuantity());
        return new TransactionStrategyImpl();
    }
}
