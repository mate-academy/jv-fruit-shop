package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;
import core.basesyntax.service.strategy.OperationHandler;

public class SupplyOperationsHandler implements OperationHandler {
    @Override
    public Operations getOperation() {
        return Operations.SUPPLY;
    }

    @Override
    public int applyOperation(int result, int quantity) {
        int newResult = result + quantity;
        if (newResult < 0) {
            return 0;
        }
        return newResult;
    }
}
