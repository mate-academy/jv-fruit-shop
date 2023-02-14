package com.fruitshop.dao;

import com.fruitshop.db.DataBase;
import com.fruitshop.model.Fruit;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    public void add(String typeOfFruit, Fruit fruit) {
        DataBase.fruitsInShop.put(typeOfFruit, fruit);
    }

    public Fruit get(String keyFruit) {
        return DataBase.fruitsInShop.get(keyFruit);
    }

    public Map<String,Fruit> getAll() {
        return DataBase.fruitsInShop;
    }
}
