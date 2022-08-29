package strategy.operations.impl;

import dao.StorageDao;
import model.Fruits;
import strategy.operations.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    private StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(Fruits fruitTransaction) {
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

