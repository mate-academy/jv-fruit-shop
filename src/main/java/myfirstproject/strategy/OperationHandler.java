package myfirstproject.strategy;

import myfirstproject.dao.FruitDao;
import myfirstproject.dao.impl.FruitDaoImpl;
import myfirstproject.model.Fruit;

public interface OperationHandler {
    FruitDao FRUIT_DAO = new FruitDaoImpl();

    void changeValue(Fruit fruit, int value);
}
