package core.basesyntax.service.operation.handler.operation.handler.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.FruitModel;
import core.basesyntax.service.operation.handler.OperationHandler;

public class BalanceOperationImpl implements OperationHandler {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void operationType(FruitModel fruitModel, int amount) {
        storageDao.addFruit(fruitModel, amount);
    }
}
