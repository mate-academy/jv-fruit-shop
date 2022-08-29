package strategy.operations.impl;

import dao.StorageDao;
import model.Fruits;
import strategy.operations.OperationHandler;

public class BalanceOperation implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(Fruits fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
