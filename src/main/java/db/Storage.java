package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void updateQuantity(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllFruits() {
        return Collections.unmodifiableMap(fruits);
    }
}

