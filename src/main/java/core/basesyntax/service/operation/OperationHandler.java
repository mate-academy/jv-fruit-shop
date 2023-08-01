package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;

public interface OperationHandler {
    public abstract Fruit completeOperation(Fruit fruit);
}
