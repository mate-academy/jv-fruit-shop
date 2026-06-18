package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void addOrUpdate(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static void merge(String fruit, int quantity) {
        fruits.merge(fruit, quantity, Integer::sum);
    }

    public static boolean contains(String fruit) {
        return fruits.containsKey(fruit);
    }

    public static int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllEntries() {
        return Map.copyOf(fruits);
    }

    public static void clear() {
        fruits.clear();
    }
}
