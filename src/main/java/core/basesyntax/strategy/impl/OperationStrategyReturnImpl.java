package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyReturnImpl implements OperationStrategy {
    @Override
    public int calculateQuantity(int quantityBefore, int currentQuantity) {
        return quantityBefore + currentQuantity;
    }

    @Override
    public int putPreviousPeriodQuantity(int quantity) {
        return quantity;
    }
}
