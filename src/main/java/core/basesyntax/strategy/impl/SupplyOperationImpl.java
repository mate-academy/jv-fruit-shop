package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(String name, int quantity) {
        Fruit fruit = fruitStorageDao.getFruit(name);
        if (fruit == null) {
            throw new RuntimeException("No such fruit in shop");
        }
        fruitStorageDao.add(fruit, fruitStorageDao.getQuantity(name) + quantity);
    }
}
