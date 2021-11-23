package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationImpl implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(String name, int quantity) {
        Fruit fruit = fruitStorageDao.getFruit(name);
        if (fruitStorageDao.getQuantity(fruit.getName()) - quantity > 0) {
            fruitStorageDao.add(fruit, fruitStorageDao.getQuantity(name) - quantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy that amount");
        }
    }
}
