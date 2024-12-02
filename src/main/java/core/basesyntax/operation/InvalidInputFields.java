package core.basesyntax.operation;

import core.basesyntax.exceptions.InvalidOperationException;
import core.basesyntax.transaction.FruitTransaction;

public class InvalidInputFields {

    protected static void invalidInputFields(FruitTransaction fruitTransition) {

        if (fruitTransition.getQuantity() < 0) {
            throw new InvalidOperationException("Quantity must be greater than 0!");
        }
        if (fruitTransition.getFruitName() == null || fruitTransition.getFruitName().isEmpty()
                || fruitTransition.getOperation() == null) {
            throw new InvalidOperationException("Fruit transition fields can't be empty or null!");
        }
    }
}
