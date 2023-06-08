package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class OperationReturnHandler implements OperationHandler {

    @Override
    public void operationHandler(FruitTransaction fruitTransaction) {
        int quantityFromDb = operationDao.get(fruitTransaction.getFruit());
        operationDao.put(fruitTransaction.getFruit(), quantityFromDb
                + fruitTransaction.getQuantity());
    }
}
