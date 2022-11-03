package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerBalance implements OperationHandler {
    private StorageDao storage;

    public OperationHandlerBalance() {
        storage = new StorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        storage.addFruit(key, value);
    }
}
