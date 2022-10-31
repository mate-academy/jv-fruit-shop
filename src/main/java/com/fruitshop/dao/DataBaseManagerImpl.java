package com.fruitshop.dao;

import com.fruitshop.db.DataBase;
import com.fruitshop.model.Fruit;
import java.util.Map;

public class DataBaseManagerImpl implements DataBaseManager {
    public void addToDB(String typeOfFruit, Fruit fruit) {
        DataBase.currentDataBase().put(typeOfFruit, fruit);
    }

    public Fruit getFromDB(String keyFruit) {
        return DataBase.currentDataBase().get(keyFruit);
    }

    public Map<String,Fruit> getAllDB() {
        return DataBase.currentDataBase();
    }
}
