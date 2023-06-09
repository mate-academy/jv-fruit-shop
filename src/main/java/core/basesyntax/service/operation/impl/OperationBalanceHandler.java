package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class OperationBalanceHandler implements OperationHandler {

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        operationDao.put(fruitTransaction.getFruit(),fruitTransaction.getQuantity());
    }
}
