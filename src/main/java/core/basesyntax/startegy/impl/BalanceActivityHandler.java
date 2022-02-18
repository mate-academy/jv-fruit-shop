package core.basesyntax.startegy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.startegy.ActivityHandler;

public class BalanceActivityHandler implements ActivityHandler {
    private FruitDao fruitDao;

    public BalanceActivityHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doActivity(String name, int quantity) {
        Fruit fruit = new Fruit(name, quantity);
        fruitDao.add(fruit);
    }
}
