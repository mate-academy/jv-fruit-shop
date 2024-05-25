package core.basesyntax.dao.dao.impl;

import core.basesyntax.dao.RemovalOperationHandler;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitModel;

public class PurchaseTransactionImpl implements RemovalOperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public int getFruitFromStorage(FruitModel fruitModel, int amount) {
        return storageDao.getFruit(fruitModel, amount);
    }
}
