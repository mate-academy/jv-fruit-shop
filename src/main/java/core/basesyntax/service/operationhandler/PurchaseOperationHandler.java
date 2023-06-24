package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class PurchaseOperationHandler implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void makeOperation(String name, int quantity) {
        int quantityFromDb = storageDao.get(name);
        int quantityToDb = quantityFromDb - quantity;
        if (quantityToDb >= 0) {
            storageDao.add(name, quantityToDb);
        } else {
            throw new RuntimeException(name + " quantity is not correct");
        }
    }
}
