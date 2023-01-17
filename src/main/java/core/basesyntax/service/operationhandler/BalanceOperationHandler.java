package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void makeOperation(String name, int quantity, StorageDao storageDao) {
        if (quantity >= 0) {
            storageDao.add(name, quantity);
        } else {
            throw new RuntimeException(name + " quantity is not correct");
        }
    }
}
