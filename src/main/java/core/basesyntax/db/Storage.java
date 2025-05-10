package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storage = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be less than 0");
        }
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be less than 0");
        }
        if (storage.containsKey(fruit) && storage.get(fruit) >= quantity) {
            storage.put(fruit, storage.get(fruit) - quantity);
        } else {
            throw new RuntimeException("Not enough fruits in storage");
        }
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
