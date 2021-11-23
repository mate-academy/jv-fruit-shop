package core.basesyntax.startegy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivityHandler;

public class AddActivityHandler implements ActivityHandler {
    private FruitDao fruitDao;

    public AddActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doActivity(String name, int quantity) {
        Fruit fruit = fruitDao.get(name);
        int newQuantity = fruit.getQuantity() + quantity;
        fruit.setQuantity(newQuantity);
    }
}
