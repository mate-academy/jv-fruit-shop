package com.fruitshop.dao;

import com.fruitshop.model.Fruit;
import java.util.Map;

public interface DataBaseManager {

    void addToDB(String typeOfFruit, Fruit fruit);

    Fruit getFromDB(String keyFruit);

    Map<String,Fruit> getAllDB();
}
