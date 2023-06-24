package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class ReturnOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(String name, int quantity) {
        int quantityFromDb = storageDao.get(name);
        if (quantity >= 0) {
            int quantityToDb = quantityFromDb + quantity;
            storageDao.add(name, quantityToDb);
        } else {
            throw new RuntimeException(name + " quantity is not correct");
        }
    }
}
