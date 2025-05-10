package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void add(String fruit, Integer amount) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + amount);
    }

    public static void remove(String fruit, Integer amount) {
        if (!fruits.containsKey(fruit) || fruits.get(fruit) < amount) {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage.");
        }
        fruits.put(fruit, fruits.get(fruit) - amount);
    }

    public static int getAmount(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
