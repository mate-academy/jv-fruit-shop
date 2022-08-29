package strategy.operations.impl;

import dao.StorageDao;
import model.FruitTransaction;
import strategy.operations.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity()
                > storageDao.remainder(fruitTransaction.getFruit())) {
            throw new RuntimeException(
                    fruitTransaction.getFruit() + " cannot be purchase.");
        }
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.remainder(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}

