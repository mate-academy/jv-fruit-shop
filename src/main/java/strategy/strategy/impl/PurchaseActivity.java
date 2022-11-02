package strategy.strategy.impl;

import dao.FruitStorageDao;
import java.util.NoSuchElementException;
import strategy.DoActivities;

public class PurchaseActivity implements DoActivities {
    private static final String EXCEPTION_MESSAGE1 = "There is no such fruit in the shop: ";
    private static final String EXCEPTION_MESSAGE2 = "Not enough fruits in the storage";
    private final FruitStorageDao storageDao;

    public PurchaseActivity(FruitStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void doActivity(String fruit, Integer number) {
        if (!storageDao.hasInDb(fruit)) {
            throw new NoSuchElementException(EXCEPTION_MESSAGE1 + fruit);
        }
        int previousNumber = storageDao.getNumer(fruit);
        int newNumber = previousNumber - number;
        if (newNumber < 0) {
            throw new RuntimeException(EXCEPTION_MESSAGE2);
        }
        storageDao.update(fruit,newNumber);
    }
}
