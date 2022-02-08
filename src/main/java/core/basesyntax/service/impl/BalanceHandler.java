package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final StorageDao<Fruit> storageDao;

    public BalanceHandler(StorageDao<Fruit> storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean operate(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity);
        return storageDao.add(fruit);
    }
}
