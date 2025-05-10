package core.basesyntax.service.operation;

import core.basesyntax.dao.StorageDaoImpl;

public class PurchaseHandler implements OperationHandler {
    private final StorageDaoImpl storageDao;

    public PurchaseHandler(StorageDaoImpl storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(String fruit, int amount) {
        storageDao.subtractFruit(fruit, amount);
    }
}
