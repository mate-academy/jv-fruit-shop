package core.basesyntax.strategy.activities;

import core.basesyntax.db.dao.StorageDao;

public class PurchaseActivitiesHandler implements ActivitiesHandler{
    StorageDao storageDao;

    @Override
    public void getActivities(String fruitType, Integer amount) {
        int different = storageDao.get(fruitType) - amount;
        storageDao.add(fruitType, different);
    }
}
