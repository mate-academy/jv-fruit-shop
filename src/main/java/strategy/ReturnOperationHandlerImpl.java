package strategy;

import dao.StorageDao;
import model.FruitTransaction;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private final StorageDao storageDao;

    public ReturnOperationHandlerImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void handle(FruitTransaction fruitTransaction) {
        storageDao.updateData(fruitTransaction.getFruit(),
                storageDao.getRemainFruit(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
