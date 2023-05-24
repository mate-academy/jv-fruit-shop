package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class ReturnCountStrategyImpl implements OperationCalculator {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
