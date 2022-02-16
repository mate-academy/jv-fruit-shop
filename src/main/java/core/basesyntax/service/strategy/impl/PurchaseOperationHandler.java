package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    private final StorageDao storageDao;

    public PurchaseOperationHandler() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void doOperation(String fruitType, String quantity) {
        Fruit fruit = new Fruit(fruitType);
        storageDao.subtractQuantity(fruit, Integer.parseInt(quantity));
    }
}
