package service.operation;

import dao.StorageDao;
import model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void processTransaction(FruitTransaction record) {
        storageDao.putFruit(record.getFruit(),record.getQuantity());
    }
}

