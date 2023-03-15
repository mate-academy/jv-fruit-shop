package core.basesyntax.service.handler.impl;

import core.basesyntax.service.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer transactionValue,Integer oldValue) {
        return transactionValue;
    }
}
