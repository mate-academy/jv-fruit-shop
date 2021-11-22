package core.basesyntax.startegy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesService;

public class SupplyActivityService implements ActivitiesService {
    @Override
    public void doActivity(String name, int quantity, StorageDao storageDao) {
        Fruit fruit = storageDao.get(name);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
    }
}
