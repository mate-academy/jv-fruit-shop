package core.basesyntax.services;

import core.basesyntax.operationhanlerservices.OperationHandler;

public interface OperationStrategy {
    public OperationHandler get(OperationType operation);
}
