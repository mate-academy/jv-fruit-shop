package core.basesyntax.operation;

import core.basesyntax.model.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
