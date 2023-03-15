package core.basesyntax.service.handler.impl;

import core.basesyntax.exception.NotEnoughFruitException;
import core.basesyntax.service.handler.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer operate(Integer transactionValue, Integer oldValue) {
        if (oldValue < transactionValue) {
            throw new NotEnoughFruitException("Not enough fruit exception");
        }
        return oldValue - transactionValue;
    }
}
