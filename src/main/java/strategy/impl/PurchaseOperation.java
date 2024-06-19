package strategy.impl;

import strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int apply(int quantity) {
        return quantity * (-1);
    }
}
