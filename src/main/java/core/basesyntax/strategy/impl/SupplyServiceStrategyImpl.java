package core.basesyntax.strategy.impl;

import core.basesyntax.Main;
import core.basesyntax.strategy.CountStrategy;

public class SupplyServiceStrategyImpl extends Main implements CountStrategy {
    @Override
    public int count(int generalAmount, int operationAmount) {
        return generalAmount + operationAmount;
    }
}
