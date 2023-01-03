package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.CountStrategy;

public class BalanceServiceStrategyImpl implements CountStrategy {

    @Override
    public int count(int generalAmount, int operationAmount) {
        return operationAmount;
    }
}
