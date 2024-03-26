package mate.fruitshop.service.strategy;

import mate.fruitshop.model.FruitTransaction;

public interface FruitTransactionHandler {
    int conductTransaction(FruitTransaction transaction, int currentQuantity);

    default void checkPositiveQuantity(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Negative value of " + transaction.getQuantity()
                    + " for transaction: " + transaction.getOperation());
        }
    }
}
