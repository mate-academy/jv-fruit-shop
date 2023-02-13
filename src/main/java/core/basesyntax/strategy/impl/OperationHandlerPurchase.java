package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerPurchase implements OperationHandler {
    private FruitStorageDao storage;

    public OperationHandlerPurchase() {
        storage = new FruitStorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        storage.modifyValue(key, storage.get(key) - value);
    }
}
