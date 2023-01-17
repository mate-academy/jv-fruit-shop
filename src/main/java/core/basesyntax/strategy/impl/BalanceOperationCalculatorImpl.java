package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class BalanceOperationCalculatorImpl implements OperationCalculator {
    @Override
    public int calculate(int balance, int quantity) {
        return quantity;
    }
}
