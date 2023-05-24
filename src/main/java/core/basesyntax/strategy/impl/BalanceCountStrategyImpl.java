package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class BalanceCountStrategyImpl implements OperationCalculator {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return operationAmount;
    }
}
