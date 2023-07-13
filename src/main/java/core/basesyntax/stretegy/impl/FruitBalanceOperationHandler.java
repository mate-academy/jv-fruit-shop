package core.basesyntax.stretegy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.FruitOperationHandler;

public class FruitBalanceOperationHandler implements FruitOperationHandler {
    private final StorageDao storageDao;

    public FruitBalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(String fruitName, int amount) {
        storageDao.add(fruitName, amount);
    }
}
