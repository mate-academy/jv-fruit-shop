package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class OperationStrategySupplyImpl implements OperationStrategy {
    @Override
    public int get(int quantityBefore, int currentQuantity) {
        return quantityBefore + currentQuantity;
    }
}
