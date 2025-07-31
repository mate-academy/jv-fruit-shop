package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }

    public static void put(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }
}
