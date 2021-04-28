package com.companyname.fruitshop.dao;

import com.companyname.fruitshop.model.Fruit;

import java.util.Map;

public interface FruitDao {
    void add(Fruit fruit);
    void update(Fruit fruit);
    Map<String, Integer> get();
    int getCurrentAmount(String fruitName);
}
