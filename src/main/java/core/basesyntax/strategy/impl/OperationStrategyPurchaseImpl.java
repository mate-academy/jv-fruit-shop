package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategyBalanceImpl implements OperationStrategy {
    @Override
    public int get(int quantityBefore, int currentQuantity) {
        quantityBefore = 0;
        return quantityBefore + currentQuantity;
    }
}
