package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.FruitTransactionHandler;

public class PurchaseHandler implements FruitTransactionHandler {
    private final StorageDao storageDao;

    public PurchaseHandler() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void handleTransaction(String fruit, int quantity) {
        storageDao.updateData(fruit, (storageDao.getData(fruit) - quantity));
    }
}
