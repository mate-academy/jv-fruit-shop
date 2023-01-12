package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.FruitTransaction;

public class PurchaseTransaction implements FruitTransaction {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void implementTransactionWithFruit(String fruit, int quantity) {
        storageDao.putInStorage(fruit, (storageDao.getQuantity(fruit) - quantity));

    }
}
