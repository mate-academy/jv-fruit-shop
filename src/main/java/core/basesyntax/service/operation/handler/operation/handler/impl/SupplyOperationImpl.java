package core.basesyntax.service.operation.handler.operation.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitModel;
import core.basesyntax.service.operation.handler.OperationHandler;

public class SupplyOperationImpl implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void operationType(FruitModel fruitType, int amount) {
        storageDao.addFruit(fruitType, amount);
    }
}
