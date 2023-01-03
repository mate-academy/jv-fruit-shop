package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.CountStrategy;

public class ReturnServiceStrategyImpl implements CountStrategy {
    @Override
    public int count(int generalAmount, int operationAmount) {
        return generalAmount + operationAmount;
    }
}
