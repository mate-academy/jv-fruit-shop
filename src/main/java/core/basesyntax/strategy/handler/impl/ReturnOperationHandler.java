package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer transactionValue, Integer oldValue) {
        if (transactionValue < 0) {
            throw new IllegalArgumentException("Invalid transaction value: " + transactionValue);
        }
        int newValue = oldValue + transactionValue;
        if (newValue < 0) {
            throw new RuntimeException("Not enough fruits");
        }
        return newValue;
    }
}
