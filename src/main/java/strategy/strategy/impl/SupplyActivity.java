package strategy.strategy.impl;

import dao.FruitStorageDao;
import strategy.DoActivities;

public class SupplyActivity implements DoActivities {
    private final FruitStorageDao storageDao;

    public SupplyActivity(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doActivity(String fruit, Integer number) {
        if (!storageDao.hasInDb(fruit)) {
            storageDao.save(fruit, number);
        } else {
            int previousNumber = storageDao.getNumer(fruit);
            int newNumber = previousNumber + number;
            storageDao.update(fruit,newNumber);
        }
    }
}
