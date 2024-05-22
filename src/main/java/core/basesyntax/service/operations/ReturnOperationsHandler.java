package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public class ReturnOperationsHandler implements OperationsHandler {

    @Override
    public Operations getOperation() {
        return Operations.RETURN;
    }

    @Override
    public int getOperationsResult(int result, int quantity) {
        return result + quantity;
    }
}
