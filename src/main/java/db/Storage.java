package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public static Integer getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static HashMap<String, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
