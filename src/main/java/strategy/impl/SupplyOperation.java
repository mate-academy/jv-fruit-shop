package strategy.impl;

import strategy.FruitOperationStrategy;

public class SupplyOperation implements FruitOperationStrategy {
    @Override
    public int execute(int currentValue, int value) {
        return currentValue + value;
    }
}
