package core.basesyntax.activities;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class PurchaseActivityHandler implements ActivitiesHandler {
    @Override
    public void doActivity(String name, int quantity, FruitsDao storageDao) {
        Fruit fruit = storageDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            int newQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(newQuantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy!!");
        }
    }
}
