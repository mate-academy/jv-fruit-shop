package core.basesyntax.service.strategy;

import core.basesyntax.model.Operations;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public Operations getOperation() {
        return Operations.RETURN;
    }

    @Override
    public int applyOperation(int result, int quantity) {
        return result + quantity;
    }
}
