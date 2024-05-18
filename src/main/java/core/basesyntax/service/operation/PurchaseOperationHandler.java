package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Operation getOperation() {
        return Operation.PURCHASE;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result - quantity;
    }
}
