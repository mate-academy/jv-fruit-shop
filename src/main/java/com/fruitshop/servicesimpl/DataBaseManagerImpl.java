package com.fruitshop.servicesimpl;

import com.fruitshop.db.DataBase;
import com.fruitshop.fruitsmodels.Fruit;
import com.fruitshop.services.DataBaseManager;
import java.util.Map;

public class DataBaseManagerImpl implements DataBaseManager {

    public void addToDB(String typeOfFruit, Fruit fruit) {
        DataBase.fruitsInShop.put(typeOfFruit, fruit);
    }

    public Fruit getFromDB(String keyFruit) {
        return DataBase.fruitsInShop.get(keyFruit);
    }

    public Map<String,Fruit> getAllDB() {
        return DataBase.fruitsInShop;
    }
}
