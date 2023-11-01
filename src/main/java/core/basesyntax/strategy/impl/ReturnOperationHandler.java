package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public ReturnOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void operate(String fruit, int quantity) {
        int updatedQuantityAfterReturn = fruitStorageDao.getQuantity(fruit) + quantity;
        fruitStorageDao.add(fruit, updatedQuantityAfterReturn);
    }
}
