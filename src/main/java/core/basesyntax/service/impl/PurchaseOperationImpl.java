package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CalculateOperation;

public class PurchaseOperationImpl implements CalculateOperation {
    private final StorageDao fruitStorageDao;

    public PurchaseOperationImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void getCalculateFruit(Fruit fruit, int amount) {
        if (fruitStorageDao.getValue(fruit) - amount < 0) {
            throw new RuntimeException("There is no sale operation");
        }
        fruitStorageDao.subtract(fruit, amount);
    }
}
