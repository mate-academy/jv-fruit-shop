package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public interface OperationHandler {
    Operation getOperation();

    int getOperationResult(int result, int quantity);
}
