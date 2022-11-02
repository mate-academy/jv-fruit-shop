package core.basesyntax.service.operation;

import core.basesyntax.service.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int doOperation(int balance, int quantity) {
        return balance + quantity;
    }
}
