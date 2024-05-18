package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Operation getOperation() {
        return Operation.SUPPLY;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
