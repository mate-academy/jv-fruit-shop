package myfirstproject.strategy;

import myfirstproject.dao.FruitDao;
import myfirstproject.dao.impl.FruitDaoImpl;
import myfirstproject.model.Fruit;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void changeValue(Fruit fruit, int value) {
        fruitDao.save(fruit, value);
    }
}
