package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;

public class SupllyOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer transactionValue, Integer oldValue) {
        if (transactionValue < 0) {
            throw new IllegalArgumentException("Invalid transaction value: " + transactionValue);
        }

        return transactionValue + oldValue;
    }
}
