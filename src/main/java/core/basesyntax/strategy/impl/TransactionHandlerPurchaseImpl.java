package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.impl.FruitsDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;

public class TransactionHandlerPurchaseImpl implements TransactionHandler {
    @Override
    public TransactionStrategy makeTransaction(FruitTransaction transaction) {
        FruitsDao fruitsDao = new FruitsDaoImpl();
        int result = fruitsDao.storageAccess().get(transaction.getFruitName())
                - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0'"
                    + " after purchase: balance " + transaction.getFruitName() + " = " + result);
        } else if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Purchased quantity couldn't be less '0'.\n"
                    + "Invalid data received from input file: purchase "
                    + transaction.getFruitName() + " = " + transaction.getQuantity());
        }
        fruitsDao.storageAccess().put(transaction.getFruitName(), result);
        return new TransactionStrategyImpl();
    }
}
