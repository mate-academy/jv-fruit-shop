package basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void subtract(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
    }

    public static int get(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }

    public static void clear() {
        fruits.clear();
    }
}
