package core.basesyntax.operations;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    long perform(Fruit fruit, long operationQuantity);
}
