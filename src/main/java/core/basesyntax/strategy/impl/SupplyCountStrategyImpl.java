package core.basesyntax.strategy.impl;

import core.basesyntax.Main;
import core.basesyntax.strategy.CountStrategy;

public class SupplyCountStrategyImpl extends Main implements CountStrategy {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
