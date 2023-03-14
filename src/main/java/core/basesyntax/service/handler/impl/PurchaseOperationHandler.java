package core.basesyntax.service.handler.impl;

import core.basesyntax.service.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer oldValue, Integer transactionValue) {
        return transactionValue - oldValue;
    }
}
