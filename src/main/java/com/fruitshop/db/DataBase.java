package com.fruitshop.db;

import com.fruitshop.model.Fruit;
import java.util.Map;
import java.util.TreeMap;

public class DataBase {
    private static Map<String, Fruit> fruitsInShop = new TreeMap<>();

    public static Map<String, Fruit> currentDataBase() {
        return fruitsInShop;
    }
}
