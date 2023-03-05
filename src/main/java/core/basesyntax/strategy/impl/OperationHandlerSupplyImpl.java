package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerSupplyImpl implements OperationHandler {
    @Override
    public int calculateQuantity(int quantityBefore, int currentQuantity) {
        if (quantityBefore < 0 || currentQuantity < 0) {
            throw new RuntimeException("Both quantities must be over 0, but there are "
                    + quantityBefore + " and " + currentQuantity);
        }
        return quantityBefore + currentQuantity;
    }
}
