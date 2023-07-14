package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitOperationHandler;

public class BalanceOperationHandler implements FruitOperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        if (storageDao == null) {
            throw new RuntimeException("StorageDao can't be null");
        }
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Fruit fruit = storageDao.get(fruitTransaction.getFruitName());
        fruit.setQuantity(fruitTransaction.getQuantity());
    }
}
