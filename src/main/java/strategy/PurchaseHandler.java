package strategy;

import dao.StorageDao;

public class PurchaseHandler implements FruitsAmountHandler {
    private StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, storageDao.get(name) - addNumber);
    }
}
