package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.strategy.OperationHandler;

public class OperationHandlerBalance implements OperationHandler {
    private FruitStorageDao storage;

    public OperationHandlerBalance() {
        storage = new FruitStorageDaoImpl();
    }

    @Override
    public void valueOperation(String key, int value) {
        storage.addFruit(key, value);
    }
}
