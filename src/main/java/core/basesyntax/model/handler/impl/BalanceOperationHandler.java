package core.basesyntax.model.handler.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.handler.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(FruitTransaction transaction) {
        fruitStorageDao.updateFruitQuantity(transaction.getFruit(), transaction.getAmount());
    }
}
