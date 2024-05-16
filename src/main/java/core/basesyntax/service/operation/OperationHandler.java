package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public interface OperationHandler {
    FruitTransaction.Operation getOperation();

    int getOperationResult(int result, int quantity);
}
