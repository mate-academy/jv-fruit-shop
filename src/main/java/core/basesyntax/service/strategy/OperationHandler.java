package core.basesyntax.service.strategy;

import core.basesyntax.model.Operations;

public interface OperationHandler {
    Operations getOperation();

    int applyOperation(int result, int quantity);
}
