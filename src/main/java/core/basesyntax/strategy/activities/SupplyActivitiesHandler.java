package core.basesyntax.strategy.activities;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.StorageDaoImpl;

public class SupplyActivitiesHandler implements ActivitiesHandler {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void activities(String fruitType, Integer amount) {
        if (storageDao.get(fruitType) == null) {
            storageDao.add(fruitType, amount);
            return;
        }
        int sum = storageDao.get(fruitType) + amount;
        storageDao.add(fruitType, sum);
    }
}
