package strategy.operations.impl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.operations.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public ReturnOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void handler(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.remainder(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
