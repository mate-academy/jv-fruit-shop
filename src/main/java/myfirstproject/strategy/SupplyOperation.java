package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.model.Fruit;

public class SupplyOperation extends Operation {
    public SupplyOperation(DataBaseDao dataBaseDao, Fruit fruit, int value) {
        dataBaseDao.saveDataToCustomDB(fruit, dataBaseDao.getRecordFromDB(fruit) + value);
    }
}
