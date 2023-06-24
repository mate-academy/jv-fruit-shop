package core.basesyntax.strategy.handler.impl;

import core.basesyntax.strategy.handler.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer transactionValue, Integer oldValue) {
        return oldValue + transactionValue;
    }
}
