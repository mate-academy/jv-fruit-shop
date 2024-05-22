package core.basesyntax.operations;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    void operation(FruitTransaction fruitTransaction);

    default void validateInPut(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException(
                    "Can't complete the operation, if quantity is negative!"
            );
        }
    }
}
