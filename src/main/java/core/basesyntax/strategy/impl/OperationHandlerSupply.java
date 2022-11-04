package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerSupply implements OperationHandler {
    private StorageDao storage;

    public OperationHandlerSupply() {
        storage = new StorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        int oldVale = storage.getFruitBalance(key);
        int newValue = oldVale + value;
        storage.addFruit(key, newValue);
    }
}
