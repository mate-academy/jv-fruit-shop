package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int operation(int amount, int quantity) {
        int purchaseResult = amount - quantity;
        if (purchaseResult < 0) {
            throw new RuntimeException("Invalid Quantity value for Purchase. "
                    + "The result must not be negative");
        }
        return purchaseResult;
    }
}
