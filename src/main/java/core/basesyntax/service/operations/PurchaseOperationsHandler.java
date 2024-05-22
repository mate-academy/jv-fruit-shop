package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;

public class PurchaseOperationsHandler implements OperationsHandler {

    @Override
    public Operations getOperation() {
        return Operations.PURCHASE;
    }

    @Override
    public int getOperationsResult(int result, int quantity) {
        return result - quantity;
    }
}
