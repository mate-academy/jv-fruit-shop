package service.strategy;

import dao.StorageDao;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(), -fruitTransaction.getQuantity());
    }
}
