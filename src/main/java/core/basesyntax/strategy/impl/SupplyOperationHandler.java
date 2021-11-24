package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public SupplyOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(String name, int quantity) {
        Fruit fruit = new Fruit(name);
        if (!fruitStorageDao.contains(fruit)) {
            throw new RuntimeException("No such fruit in shop");
        }
        fruitStorageDao.add(fruit, fruitStorageDao.getQuantity(fruit) + quantity);
    }
}
