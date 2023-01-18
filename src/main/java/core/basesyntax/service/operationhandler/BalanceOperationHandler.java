package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class BalanceOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(String name, int quantity) {
        if (quantity >= 0) {
            storageDao.add(name, quantity);
        } else {
            throw new RuntimeException(name + " quantity is not correct");
        }
    }
}
