package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.FruitTransaction;

public class BalanceTransaction implements FruitTransaction {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void implementTransactionWithFruit(String fruit, int quantity) {
        storageDao.putInData(fruit, quantity);
    }
}
