package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerPurchase implements OperationHandler {
    private StorageDao storage;

    public OperationHandlerPurchase() {
        storage = new StorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        int oldValue = storage.getFruitBalance(key);
        int newValue = oldValue + value;
        storage.addFruit(key, newValue);
    }
}
