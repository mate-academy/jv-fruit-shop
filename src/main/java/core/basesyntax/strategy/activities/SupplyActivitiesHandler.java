package core.basesyntax.strategy.activities;

import core.basesyntax.db.dao.StorageDao;

public class SupplyActivitiesHandler implements ActivitiesHandler{
    StorageDao storageDao;

    @Override
    public void getActivities(String fruitType, Integer amount) {
        int sum = storageDao.get(fruitType) + amount;
        storageDao.add(fruitType, sum);
    }
}
