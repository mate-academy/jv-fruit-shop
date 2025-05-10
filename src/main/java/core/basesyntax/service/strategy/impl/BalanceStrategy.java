package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.strategy.OperationStrategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public int execute(int balanceValue, int valueToChangeBalance) {
        return valueToChangeBalance;
    }
}
