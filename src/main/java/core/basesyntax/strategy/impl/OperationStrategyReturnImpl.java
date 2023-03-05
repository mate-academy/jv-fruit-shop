package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyReturnImpl implements OperationStrategy {
    @Override
    public int calculateQuantity(int quantityBefore, int currentQuantity) {
        if (quantityBefore < 0 || currentQuantity < 0) {
            throw new RuntimeException("Both quantity must be over 0, but there are "
                    + quantityBefore + " and " + currentQuantity);
        }
        return quantityBefore + currentQuantity;
    }

    @Override
    public int putPreviousPeriodQuantity(int quantity) {
        throw new RuntimeException("In this case you should use calculateQuantity() method");
    }
}
