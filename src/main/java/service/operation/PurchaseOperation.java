package service.operation;

import dao.StorageDao;
import model.Transaction;

public class PurchaseOperation implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseOperation(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void proceed(Transaction transaction) {
        if (storageDao.getAmount(transaction.getFruit()) < transaction.getQuantity()) {
            throw new RuntimeException("Insufficient products. Available: "
                    + storageDao.getAmount(transaction.getFruit())
                    + ", try to buy: " + transaction.getQuantity());
        }
        int newAmount = storageDao.getAmount(transaction.getFruit()) - transaction.getQuantity();
        storageDao.addFruitToStorage(transaction.getFruit(), newAmount);
    }
}
