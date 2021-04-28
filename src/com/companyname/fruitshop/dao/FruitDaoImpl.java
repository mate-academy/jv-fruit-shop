package com.companyname.fruitshop.dao;

import com.companyname.fruitshop.model.Fruit;
import com.companyname.fruitshop.storage.FruitStorage;

import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        FruitStorage.getFruits().put(fruit.getName(), fruit.getCount());
    }

    @Override
    public void update(Fruit fruit) {
        add(fruit);
    }

    @Override
    public Map<String, Integer> get() {
        return FruitStorage.getFruits();
    }

    @Override
    public int getCurrentAmount(String fruitName) {
        return FruitStorage.getFruits().get(fruitName);
    }
}
