package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int totalQuantity, int quantity) {
        return totalQuantity -= quantity;
    }
}
