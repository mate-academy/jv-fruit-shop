package strategy.operations.impl;

import dao.StorageDao;
import model.Fruits;
import strategy.operations.OperationHandler;

public class ReturnOperation implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void handler(Fruits fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.remainder(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
