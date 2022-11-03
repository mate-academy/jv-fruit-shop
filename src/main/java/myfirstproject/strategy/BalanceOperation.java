package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.model.Fruit;

public class BalanceOperation {
    public BalanceOperation(DataBaseDao dataBaseDao, Fruit fruit, int value) {
        dataBaseDao.saveDataToCustomDB(fruit, value);
    }
}
