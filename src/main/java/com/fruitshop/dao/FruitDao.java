package com.fruitshop.dao;

import com.fruitshop.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void add(String typeOfFruit, Fruit fruit);

    Fruit get(String keyFruit);

    Map<String,Fruit> getAll();
}
