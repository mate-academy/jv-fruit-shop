package strategy;

import dao.StorageDao;
import db.Storage;

public class ReturnHandler implements FruitsAmountHandler {
    private StorageDao storageDao;

    public ReturnHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, Storage.report.get(name) + addNumber);
    }
}
