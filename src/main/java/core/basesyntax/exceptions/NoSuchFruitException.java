package core.basesyntax.exceptions;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;

public class NoSuchFruitException extends RuntimeException {
    public NoSuchFruitException(OperationType operationType, Fruit fruit) {
        super("For the operation "
                + operationType
                + " there is no such fruit in the storage: "
                + fruit.getName());
    }
}
