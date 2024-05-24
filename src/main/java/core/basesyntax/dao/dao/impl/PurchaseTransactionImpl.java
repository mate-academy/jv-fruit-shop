package core.basesyntax.dao.dao.impl;

import core.basesyntax.dao.RemoveTransaction;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitModel;

public class PurchaseTransactionImpl implements RemoveTransaction {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public int getFruitFromStorage(FruitModel fruitModel, int amount) {
        return storageDao.getFruit(fruitModel, amount);
    }
}
