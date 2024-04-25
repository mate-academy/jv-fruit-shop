package strategy.impl;

import strategy.FruitOperationStrategy;

public class PurchaseOperation implements FruitOperationStrategy {
    @Override
    public int execute(int currentValue, int value) {
        return currentValue - value;
    }
}
