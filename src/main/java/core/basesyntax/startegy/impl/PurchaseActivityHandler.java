package core.basesyntax.startegy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivityHandler;

public class PurchaseActivityHandler implements ActivityHandler {
    private FruitDao fruitDao;

    public PurchaseActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doActivity(String name, int quantity) {
        Fruit fruit = fruitDao.get(name);
        if (quantity <= fruit.getQuantity()) {
            int newQuantity = fruit.getQuantity() - quantity;
            fruit.setQuantity(newQuantity);
        } else {
            throw new RuntimeException("Not enough fruits to buy!!");
        }
    }
}
