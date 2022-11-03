package myfirstproject.strategy;

import myfirstproject.model.Fruit;

public class BalanceOperation implements OperationHandler {
    @Override
    public void changeValue(Fruit fruit, int value) {
        dataBaseDao.saveDataToCustomDB(fruit, value);
    }
}
