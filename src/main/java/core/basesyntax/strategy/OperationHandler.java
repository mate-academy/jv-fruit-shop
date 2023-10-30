package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    int count(FruitTransaction fruitTransaction);

    default void checkQuantityLessThenZero(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be less then zero: " + quantity);
        }
    }
}
