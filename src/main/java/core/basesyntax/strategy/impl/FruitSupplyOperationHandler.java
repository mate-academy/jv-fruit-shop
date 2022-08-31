package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.FruitOperationHandler;

public class FruitSupplyOperationHandler implements FruitOperationHandler {
    private final StorageDao storageDao;

    public FruitSupplyOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void operate(String fruitName, int amount) {
        storageDao.supply(fruitName, amount);
    }
}
