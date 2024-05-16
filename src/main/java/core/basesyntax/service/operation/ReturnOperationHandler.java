package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.RETURN;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
