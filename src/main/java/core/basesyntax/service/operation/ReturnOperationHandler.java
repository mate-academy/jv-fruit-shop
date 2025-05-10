package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Operation getOperation() {
        return Operation.RETURN;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
