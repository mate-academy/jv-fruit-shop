package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void operate(String fruit, int quantity, FruitStorageDao fruitStorageDao) {
        int updatedQuantityAfterReturn = fruitStorageDao.getQuantity(fruit) + quantity;
        fruitStorageDao.add(fruit, updatedQuantityAfterReturn);
    }
}
