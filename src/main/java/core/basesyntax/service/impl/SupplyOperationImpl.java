package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CalculateOperation;

public class SupplyOperationImpl implements CalculateOperation {
    private final StorageDao fruitStorageDao;

    public SupplyOperationImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void getCalculateFruit(Fruit fruit, int amount) {
        if (fruitStorageDao.containsKey(fruit)) {
            fruitStorageDao.supply(fruit, amount);
        } else {
            fruitStorageDao.add(fruit, amount);
        }
    }
}

