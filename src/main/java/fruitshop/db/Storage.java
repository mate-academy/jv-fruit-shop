package fruitshop.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static Integer get(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(fruits);
    }
}
