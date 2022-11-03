package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.model.Fruit;

public class ReturnOperation extends Operation {
    public ReturnOperation(DataBaseDao dataBaseDao, Fruit fruit, int value) {
        dataBaseDao.saveDataToCustomDB(fruit, dataBaseDao.getRecordFromDB(fruit) + value);
    }
}
