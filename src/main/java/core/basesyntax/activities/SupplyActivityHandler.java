package core.basesyntax.activities;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class SupplyActivityHandler implements ActivitiesHandler {
    @Override
    public void doActivity(String name, int quantity, FruitsDao storageDao) {
        Fruit fruit = storageDao.get(name);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
    }
}
