package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionStrategy;
import core.basesyntax.service.impl.TransactionStrategyImpl;

public class TransactionHandlerPurchaseImpl implements TransactionHandler {
    @Override
    public TransactionStrategy makeTransaction(FruitTransaction transaction) {
        int result = Storage.getFruits().get(transaction.getFruitName())
                - transaction.getQuantity();
        if (result < 0) {
            throw new RuntimeException("Balance couldn't be less '0'"
                    + " after purchase: balance " + transaction.getFruitName() + " = " + result);
        } else if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Purchased quantity couldn't be less '0'.\n"
                    + "Invalid data received from input file: purchase "
                    + transaction.getFruitName() + " = " + transaction.getQuantity());
        }
        Storage.getFruits().put(transaction.getFruitName(), result);
        return new TransactionStrategyImpl();
    }
}
