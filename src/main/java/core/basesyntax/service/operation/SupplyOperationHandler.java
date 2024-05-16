package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.SUPPLY;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
