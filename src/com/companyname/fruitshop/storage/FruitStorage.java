package com.companyname.fruitshop.storage;

import com.companyname.fruitshop.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    public static Map<Fruit, Integer> getFruits() {
        return fruits;
    }
}
