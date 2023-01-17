package core.basesyntax.service.operationhandler;

import core.basesyntax.dao.StorageDao;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public void makeOperation(String name, int quantity, StorageDao storageDao) {
        int quantityFromDb = storageDao.get(name);
        if (quantity >= 0) {
            int quantityToDb = quantityFromDb + quantity;
            storageDao.update(name, quantityToDb);
        } else {
            throw new RuntimeException(name + " quantity is not correct");
        }
    }
}
