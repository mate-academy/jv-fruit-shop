package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void makeOperation(String name, int quantity, StorageDao storageDao) {
        storageDao.add(name, quantity);
    }
}
