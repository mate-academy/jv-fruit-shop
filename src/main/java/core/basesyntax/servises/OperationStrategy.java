package core.basesyntax.servises;

import core.basesyntax.operationhanlerservises.OperationHandler;

public interface OperationStrategy {
    public OperationHandler get(OperationType operation);
}
