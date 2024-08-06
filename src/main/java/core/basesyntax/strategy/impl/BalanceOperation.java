package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.Operation;
import core.basesyntax.strategy.OperationException;

public class BalanceOperation implements Operation {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        if (!storageDao.get(fruitTransaction.getFruitName()).equals(null)) {
            throw new OperationException("Fruit " + fruitTransaction.getFruitName() + " already exist");
        }
        Fruit fruit = new Fruit(fruitTransaction.getFruitName(), fruitTransaction.getQuantity());
        storageDao.add(fruit);
    }
}
