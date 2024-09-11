package core.basesyntax.service.impl.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    boolean applyOperation(Fruit fruit, int quantity);
}
