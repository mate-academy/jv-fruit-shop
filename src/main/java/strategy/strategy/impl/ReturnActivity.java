package strategy.strategy.impl;

import dao.FruitStorageDao;
import strategy.DoActivities;

public class ReturnActivity implements DoActivities {
    private static final String EXCEPTION_MESSAGE = "There was no fruit like that in the storage";
    private final FruitStorageDao storageDao;

    public ReturnActivity(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doActivity(String fruit, Integer number) {
        if (!storageDao.hasInDb(fruit)) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        int previousNumber = storageDao.getNumer(fruit);
        int newNumber = previousNumber + number;
        storageDao.update(fruit,newNumber);
    }
}
