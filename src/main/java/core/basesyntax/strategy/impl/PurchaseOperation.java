package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class PurchaseOperation implements Operation {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }
    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        if (storageDao.get(fruitTransaction.getFruitName()).equals(null)) {
            throw new OperationException("Fruit " + fruitTransaction.getFruitName() + " doesn't exist");
        }
        Fruit fruit = storageDao.get(fruitTransaction.getFruitName());
        fruit.setQuantity(fruit.getQuantity() - fruitTransaction.getQuantity());
    }
}
