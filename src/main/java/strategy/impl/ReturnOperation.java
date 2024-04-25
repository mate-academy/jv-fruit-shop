package strategy.impl;

import strategy.FruitOperationStrategy;

public class ReturnOperation implements FruitOperationStrategy {
    @Override
    public int execute(int currentValue, int value) {
        return currentValue + value;
    }
}
