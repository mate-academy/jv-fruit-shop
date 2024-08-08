package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class BalanceOperation implements Operation {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(FruitOperation fruitOperation) {
        if (storageDao.get(fruitOperation.getFruitName()) != null) {
            throw new OperationException("Fruit " + fruitOperation.getFruitName()
                    + " already exist");
        }
        Fruit fruit = new Fruit(fruitOperation.getFruitName(), fruitOperation.getQuantity());
        storageDao.add(fruit);
    }
}
