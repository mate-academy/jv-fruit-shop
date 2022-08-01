package handler;

import dao.StorageDao;
import model.FruitTransaction;

public class OperationHandlerBalance implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerBalance(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
