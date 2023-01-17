package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationCalculator;

public class ReturnOperationCalculatorImpl implements OperationCalculator {
    @Override
    public int calculate(int balance, int quantity) {
        return balance + quantity;
    }
}
