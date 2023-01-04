package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.CountStrategy;

public class BalanceCountStrategyImpl implements CountStrategy {

    @Override
    public int count(int currentAmount, int operationAmount) {
        return operationAmount;
    }
}
