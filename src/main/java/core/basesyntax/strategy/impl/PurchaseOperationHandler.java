package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public PurchaseOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(String name, int quantity) {
        Fruit fruit = new Fruit(name);
        if (fruitStorageDao.contains(fruit)
                && fruitStorageDao.getQuantity(fruit) - quantity >= 0) {
            fruitStorageDao.add(fruit, fruitStorageDao.getQuantity(fruit) - quantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy that amount");
        }
    }
}
