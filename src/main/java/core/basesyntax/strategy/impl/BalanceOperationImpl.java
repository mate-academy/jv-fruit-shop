package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public void handleOperation(String name, int quantity) {
        fruitStorageDao.add(new Fruit(name), quantity);
    }
}
