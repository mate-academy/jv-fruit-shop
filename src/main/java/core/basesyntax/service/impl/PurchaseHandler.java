package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao<Fruit> storageDao;

    public PurchaseHandler(StorageDao<Fruit> storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean operate(String fruitName, int quantity) {
        Fruit prevFruit = storageDao.getFruit(fruitName);
        int curr = prevFruit.getQuantity();
        if (curr < quantity) {
            throw new RuntimeException("Not enough fruits to buy");
        }
        Fruit fruit = new Fruit(fruitName, curr - quantity);
        return storageDao.update(prevFruit, fruit);
    }
}
