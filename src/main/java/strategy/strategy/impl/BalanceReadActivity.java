package strategy.strategy.impl;

import dao.FruitStorageDao;
import strategy.DoActivities;

public class BalanceReadActivity implements DoActivities {
    private FruitStorageDao storageDao;

    public BalanceReadActivity(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doActivity(String fruit, Integer number) {
        storageDao.save(fruit, number);
    }
}
