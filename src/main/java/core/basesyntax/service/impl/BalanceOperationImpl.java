package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CalculateOperation;

public class BalanceOperationImpl implements CalculateOperation {
    private final StorageDao fruitStorageDao;

    public BalanceOperationImpl(StorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void getCalculateFruit(Fruit fruit, int amount) {
        fruitStorageDao.add(fruit, amount);
    }
}
