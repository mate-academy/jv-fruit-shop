package core.basesyntax.service.impl;

import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int totalQuantity, int quantity) {
        return totalQuantity -= quantity;
    }
}
