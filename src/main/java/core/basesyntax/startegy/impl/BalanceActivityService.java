package core.basesyntax.startegy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesService;

public class BalanceActivityService implements ActivitiesService {
    @Override
    public void doActivity(String name, int quantity, StorageDao storageDao) {
        Fruit fruit = new Fruit(name, quantity);
        storageDao.add(fruit);
    }
}
