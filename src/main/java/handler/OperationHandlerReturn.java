package handler;

import dao.StorageDao;
import model.FruitTransaction;

public class OperationHandlerReturn implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerReturn(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getFruitQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
