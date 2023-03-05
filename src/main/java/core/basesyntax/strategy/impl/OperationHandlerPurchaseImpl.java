package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerPurchaseImpl implements OperationHandler {
    @Override
    public int calculateQuantity(int quantityBefore, int currentQuantity) {
        int result = quantityBefore - currentQuantity;
        if (result < 0) {
            throw new RuntimeException("Result must be over 0, but it is " + result);
        }
        if (quantityBefore < 0 || currentQuantity < 0) {
            throw new RuntimeException("Both quantities must be over 0, but there are "
                    + quantityBefore + " and " + currentQuantity);
        }
        return result;
    }
}
