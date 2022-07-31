package handler;

import dao.StorageDao;
import model.FruitTransaction;

public class OperationHandlerSupply implements OperationHandler {
    private final StorageDao storageDao;

    public OperationHandlerSupply(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storageDao.update(fruitTransaction.getFruit(),
                storageDao.getFruitQuantity(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
