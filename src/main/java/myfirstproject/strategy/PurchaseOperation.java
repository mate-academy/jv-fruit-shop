package myfirstproject.strategy;

import myfirstproject.dao.DataBaseDao;
import myfirstproject.model.Fruit;

public class PurchaseOperation extends Operation {
    public PurchaseOperation(DataBaseDao dataBaseDao, Fruit fruit, int value) {
        dataBaseDao.saveDataToCustomDB(fruit, dataBaseDao.getRecordFromDB(fruit) - value);
    }
}
