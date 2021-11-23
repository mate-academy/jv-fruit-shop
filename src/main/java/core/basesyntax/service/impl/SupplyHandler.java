package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class SupplyHandler implements OperationHandler {
    private final StorageDao<Fruit> storageDao;

    public SupplyHandler(StorageDao<Fruit> storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean operate(String fruitName, int quantity) {
        Fruit prevFruit = storageDao.getFruit(fruitName);
        int curr = prevFruit.getQuantity();
        Fruit fruit = new Fruit(fruitName, quantity + curr);
        return storageDao.update(prevFruit, fruit);
    }
}
