package service.operation;

import dao.StorageDao;
import model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private final StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void processTransaction(FruitTransaction record) {
        int value = storageDao.getMap().get(record.getFruit()) - record.getQuantity();
        if (value < 0) {
            throw new RuntimeException("Not enough " + record.getFruit());
        }
        storageDao.putFruit(record.getFruit(),value);
    }
}
