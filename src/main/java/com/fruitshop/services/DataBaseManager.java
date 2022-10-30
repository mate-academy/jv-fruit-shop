package com.fruitshop.services;

import com.fruitshop.fruitsmodels.Fruit;
import java.util.Map;

public interface DataBaseManager {

    void addToDB(String typeOfFruit, Fruit fruit);

    Fruit getFromDB(String keyFruit);

    Map<String,Fruit> getAllDB();
}
