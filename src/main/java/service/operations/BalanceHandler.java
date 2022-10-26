package service.operations;

import dao.StorageDao;

public class BalanceHandler implements OperationsHandler {
    private StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doOperation(String fruitName, Integer quantity) {
        storageDao.set(fruitName, quantity);
    }
}
