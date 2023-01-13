package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class BalanceHandlerStrategyImpl implements OperationCalculator {
    @Override
    public int count(int currentAmount, int operationAmount) {
        return operationAmount;
    }
}
