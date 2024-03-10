package service.operation;

import dao.StorageDao;
import model.Transaction;

public class SupplyOperation implements OperationHandler {
    private final StorageDao storageDao;

    public SupplyOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        int newAmount = storageDao.getAmount(transaction.getFruit()) + transaction.getQuantity();
        storageDao.addFruitToStorage(transaction.getFruit(), newAmount);
    }
}
