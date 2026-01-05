package core.basesyntax.strategy;

import core.basesyntax.model.Operation;

public interface Strategy {
    public OperationHandler getOperationHandler(Operation operation);
}
