package core.basesyntax.activities;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class BalanceActivityHandler implements ActivitiesHandler {
    @Override
    public void doActivity(String name, int quantity, FruitsDao storageDao) {
        Fruit fruit = new Fruit(name, quantity);
        storageDao.add(fruit);
    }
}
