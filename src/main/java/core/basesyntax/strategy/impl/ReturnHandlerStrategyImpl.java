package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class ReturnHandlerStrategyImpl implements OperationCalculator {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
