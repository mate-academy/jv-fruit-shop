package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerReturn implements OperationHandler {
    private FruitStorageDao storage;

    public OperationHandlerReturn() {
        storage = new FruitStorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        storage.modifyValue(key, storage.get(key) + value);
    }
}
