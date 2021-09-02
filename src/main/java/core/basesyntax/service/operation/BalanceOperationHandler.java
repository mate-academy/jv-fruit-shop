package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getAmount(Operation operation) {
        return operation.getAmount();
    }
}
