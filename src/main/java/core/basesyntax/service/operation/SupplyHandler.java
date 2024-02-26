package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDaoImpl;

public class SupplyHandler implements OperationHandler {
    private final StorageDaoImpl storageDao;

    public SupplyHandler(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String fruit, int amount) {
        storageDao.addFruit(fruit, amount);
    }
}
