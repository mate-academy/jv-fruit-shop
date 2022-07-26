package core.basesyntax.handlers;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(Fruit fruit, Integer quantity) {
        storageDao.add(fruit, quantity);
    }
}
