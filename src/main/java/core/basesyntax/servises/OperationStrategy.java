package core.basesyntax.servises;

import core.basesyntax.operation_hanler_servises.OperationHandler;

public interface OperationStrategy {
    public OperationHandler get(OperationType operation);
}
