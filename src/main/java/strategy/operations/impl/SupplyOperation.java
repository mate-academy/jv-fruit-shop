package strategy.operations.impl;

import dao.StorageDao;
import model.Fruits;
import strategy.operations.OperationHandler;

public class SupplyOperation implements OperationHandler {
    private StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(Fruits fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.remainder(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
