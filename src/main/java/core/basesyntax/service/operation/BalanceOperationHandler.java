package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation() {
        return FruitTransaction.Operation.BALANCE;
    }

    @Override
    public int getOperationResult(int result, int quantity) {
        return result + quantity;
    }
}
