package handler;

import dao.StorageDao;
import model.FruitTransaction;

public class OperationHandlerPurchase implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerPurchase(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getFruitQuantity(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
