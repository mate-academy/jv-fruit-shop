package core.basesyntax.service.strategy;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    public OperationHandler getHandler(Operation operation);
}
