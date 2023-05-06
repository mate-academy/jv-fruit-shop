package strategy.operations.impl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.operations.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public BalanceOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
