package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public class SupplyOperationsHandler implements OperationsHandler {

    @Override
    public Operations getOperation() {
        return Operations.SUPPLY;
    }

    @Override
    public int getOperationsResult(int result, int quantity) {
        return result + quantity;
    }
}
