package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.TransactionStrategyImpl;

public class TransactionHandlerImpl implements TransactionHandler {

    @Override
    public TransactionStrategy makeTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Balance couldn't be less '0'.\n"
                    + " Invalid data received from input file: balance "
                    + transaction.getFruitName() + " = " + transaction.getQuantity());
        }
        Storage.getFruits().put(transaction.getFruitName(), transaction.getQuantity());
        return new TransactionStrategyImpl();
    }
}
