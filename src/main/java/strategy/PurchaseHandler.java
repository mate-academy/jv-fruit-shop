package strategy;

import dao.StorageDao;
import db.Storage;

public class PurchaseHandler implements FruitsAmountHandler {
    private StorageDao storageDao;

    public PurchaseHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, Storage.report.get(name) - addNumber);
    }
}
