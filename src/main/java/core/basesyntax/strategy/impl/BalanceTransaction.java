package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.FruitTransactionHandler;

public class BalanceTransaction implements FruitTransactionHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void handleTransaction(String fruit, int quantity) {
        storageDao.putInData(fruit, quantity);
    }
}
