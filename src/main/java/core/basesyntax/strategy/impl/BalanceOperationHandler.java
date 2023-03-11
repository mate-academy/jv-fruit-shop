package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitStorageDao fruitStorageDao;

    public BalanceOperationHandler(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void handleOperation(String name, int quantity) {
        fruitStorageDao.add(new Fruit(name), quantity);
    }
}
