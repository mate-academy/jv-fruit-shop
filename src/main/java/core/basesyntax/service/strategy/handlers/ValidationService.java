package core.basesyntax.service.strategy.handlers;

import core.basesyntax.db.StorageDao;

public class ValidationService {
    private final StorageDao storageDao;

    public ValidationService(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void validateIncreasing(String fruit) {
        if (!storageDao.isInStorage(fruit)) {
            throw new RuntimeException("There is not fruit called " + fruit + " in Storage");
        }
    }

    public void validateAddingNew(String fruit) {
        if (storageDao.isInStorage(fruit)) {
            throw new RuntimeException("Fruit " + fruit + " already exists in Storage");
        }
    }

    public void validateDecreasing(String fruit, int quantity) {
        if (!storageDao.isInStorage(fruit)) {
            throw new RuntimeException("There is not fruit called " + fruit + " in Storage");
        }
        int rest = storageDao.getAmountOf(fruit) - quantity;
        if (rest < 0) {
            throw new RuntimeException("Fruit amount can`t be less than 0, but going to be "
                    + rest);
        }
    }
}
