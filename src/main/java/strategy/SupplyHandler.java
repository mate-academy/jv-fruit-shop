package strategy;

import dao.StorageDao;

public class SupplyHandler implements FruitsAmountHandler {
    private StorageDao storageDao;

    public SupplyHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, storageDao.get(name) + addNumber);
    }

}
