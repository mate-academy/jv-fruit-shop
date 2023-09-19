package core.basesyntax.model.handler.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitStorageDao fruitStorageDao;

    public BalanceOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        fruitStorageDao.updateFruitQuantity(transaction.getFruit(), transaction.getAmount());
    }
}
