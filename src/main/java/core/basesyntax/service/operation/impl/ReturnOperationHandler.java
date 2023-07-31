package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int calculationData(int balance, FruitTransaction transaction) {
        return balance + transaction.getQuantity();
    }
}

