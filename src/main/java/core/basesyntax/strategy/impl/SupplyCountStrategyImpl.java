package core.basesyntax.strategy.impl;

import core.basesyntax.Main;
import core.basesyntax.strategy.OperationCalculator;

public class SupplyCountStrategyImpl extends Main implements OperationCalculator {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
