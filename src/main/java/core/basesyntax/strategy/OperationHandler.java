package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void process(FruitTransaction fruitTransaction);

    default void validateTransaction(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("Transaction cannot be null");
        }
        if (fruitTransaction.getFruit() == null) {
            throw new RuntimeException("Fruit cannot be null");
        }

        if (fruitTransaction.getFruit().isEmpty()) {
            throw new RuntimeException("Fruit cannot be empty");
        }
        if (fruitTransaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative: "
                    + fruitTransaction.getQuantity());
        }
    }
}
