package com.fruitshop.db;

import com.fruitshop.fruitsmodels.Fruit;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<String, Fruit> fruitsInShop = new HashMap<>();

    public static Map<String, Fruit> currentDataBase() {
        return fruitsInShop;
    }
}
