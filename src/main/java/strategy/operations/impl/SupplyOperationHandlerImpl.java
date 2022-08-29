package strategy.operations.impl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.operations.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public SupplyOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.remainder(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
