package core.basesyntax.service.handler.impl;

import core.basesyntax.model.FruitTransaction;

public class BaseOperationHandler {
    public void checkTransaction(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Quantity can't be less than 0");
        }
    }
}
