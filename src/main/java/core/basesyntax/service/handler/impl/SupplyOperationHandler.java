package core.basesyntax.service.handler.impl;

import core.basesyntax.service.handler.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer oldValue, Integer transactionValue) {
        return oldValue + transactionValue;
    }
}
