package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Operation getOperation() {
        return Operation.BALANCE;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
