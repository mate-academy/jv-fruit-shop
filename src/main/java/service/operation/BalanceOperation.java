package service.operation;

import dao.StorageDao;
import model.Transaction;

public class BalanceOperation implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("Product amount can't be negative. Transaction value: "
                    + transaction.getQuantity());
        }
        storageDao.addFruitToStorage(transaction.getFruit(), transaction.getQuantity());
    }
}
