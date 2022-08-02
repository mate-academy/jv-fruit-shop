package handler;

import dao.StorageDao;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getFruitQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
