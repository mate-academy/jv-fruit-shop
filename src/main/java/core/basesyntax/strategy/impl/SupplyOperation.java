package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class SupplyOperation implements Operation {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(FruitOperation fruitOperation) {
        if (storageDao.get(fruitOperation.getFruitName()) == null) {
            throw new OperationException("Fruit " + fruitOperation.getFruitName()
                    + " doesn't exist");
        }
        Fruit fruit = storageDao.get(fruitOperation.getFruitName());
        fruit.setQuantity(fruit.getQuantity() + fruitOperation.getQuantity());
    }
}
