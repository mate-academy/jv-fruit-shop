package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationsHandler implements OperationHandler {
    @Override
    public Operations getOperation() {
        return Operations.BALANCE;
    }

    @Override
    public int applyOperation(int result, int quantity) {
        return result + quantity;
    }
}
