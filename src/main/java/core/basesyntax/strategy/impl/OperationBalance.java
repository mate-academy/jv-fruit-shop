package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class OperationBalance implements OperationHandler {
    private final FruitStorageDao storageDao;

    public OperationBalance(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operationWithFruitTransaction(FruitTransaction fruitTransaction) {
        storageDao.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
