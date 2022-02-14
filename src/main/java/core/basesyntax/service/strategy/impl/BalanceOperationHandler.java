package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    private StorageDao storageDao;

    public BalanceOperationHandler() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void doOperation(String fruitType, String quantity) {
        Fruit fruit = new Fruit(fruitType);
        storageDao.addFruit(fruit);
        storageDao.addQuantity(fruit, Integer.parseInt(quantity));
    }
}
