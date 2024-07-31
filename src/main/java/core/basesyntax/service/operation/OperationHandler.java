package core.basesyntax.service.operation;

import core.basesyntax.domain.FruitTransaction;

public interface OperationHandler {
    void calculateQuantity(FruitTransaction.FruitName fruitName, int quantity);

    default void validateFruitName(FruitTransaction.FruitName fruitName) {
        if (fruitName == null) {
            throw new RuntimeException("Fruit name can't be null");
        }
    }

    default void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be less than 0");
        }
    }
}
