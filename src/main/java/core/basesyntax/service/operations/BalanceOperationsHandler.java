package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public class BalanceOperationsHandler implements OperationsHandler {

    @Override
    public Operations getOperation() {
        return Operations.BALANCE;
    }

    @Override
    public int getOperationsResult(int result, int quantity) {
        return result + quantity;
    }
}
