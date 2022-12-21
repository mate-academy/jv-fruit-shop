package core.basesyntax.strategy.operationstrategy.impl;

import core.basesyntax.strategy.operationstrategy.OperationCalculator;

public class ReturnOperationCalculatorImpl implements OperationCalculator {
    @Override
    public int calculate(int currentQuantity, int operationQuantity) {
        return currentQuantity + operationQuantity;
    }
}
