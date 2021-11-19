package core.basesyntax.startegy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivitiesService;

public class PurchaseActivityService implements ActivitiesService {
    @Override
    public void getActivity(String name, int quantity, StorageDao storageDao) {
        Fruit fruit = storageDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            int newQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(newQuantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy!!");
        }
    }
}
