package strategy.impl;

import strategy.FruitOperationStrategy;

public class BalanceOperation implements FruitOperationStrategy {
    @Override
    public int execute(int currentValue, int value) {
        return value;
    }
}
