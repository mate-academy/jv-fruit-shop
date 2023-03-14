package core.basesyntax.service.handler.impl;

import core.basesyntax.service.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer oldValue, Integer transactionValue) {
        return oldValue;
    }
}
