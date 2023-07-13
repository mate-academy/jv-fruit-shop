package core.basesyntax.stretegy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.FruitOperationHandler;

public class FruitReturnOperationHandler implements FruitOperationHandler {
    private final StorageDao storageDao;

    public FruitReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(String fruitName, int amount) {
        storageDao.supply(fruitName, amount);
    }
}
