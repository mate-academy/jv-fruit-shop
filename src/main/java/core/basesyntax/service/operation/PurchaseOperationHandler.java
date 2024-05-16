package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.PURCHASE;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result - quantity;
    }
}
