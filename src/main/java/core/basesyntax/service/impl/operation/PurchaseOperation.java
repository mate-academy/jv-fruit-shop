package core.basesyntax.service.impl.operation;

import core.basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int executeOperation(int initBalance, int quantity) {
        return initBalance - quantity;
    }
}
