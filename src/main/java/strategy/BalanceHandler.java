package strategy;

import dao.StorageDao;

public class BalanceHandler implements FruitsAmountHandler {
    private StorageDao storageDao;

    public BalanceHandler(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void updateAmount(String name, Integer addNumber) {
        storageDao.update(name, addNumber);
    }
}
