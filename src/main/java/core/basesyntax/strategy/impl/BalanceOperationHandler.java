package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void operate(String fruit, int quantity, FruitStorageDao fruitStorageDao) {
        fruitStorageDao.add(fruit, quantity);
    }
}
