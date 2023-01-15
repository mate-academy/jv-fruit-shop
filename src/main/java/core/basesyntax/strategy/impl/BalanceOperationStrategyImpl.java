package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationStrategy;

public class BalanceOperationStrategyImpl implements OperationStrategy {
    @Override
    public int execute(int balance, int quantity) {
        return quantity;
    }
}
