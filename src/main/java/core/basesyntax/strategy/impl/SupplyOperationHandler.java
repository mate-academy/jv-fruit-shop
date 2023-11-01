package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public SupplyOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void operate(String fruit, int quantity) {
        int updatedQuantity = fruitStorageDao.getQuantity(fruit) + quantity;
        fruitStorageDao.add(fruit, updatedQuantity);
    }
}
