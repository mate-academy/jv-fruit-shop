package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static Map<String, Integer> getStorage() {
        return storage;
    }

    public static void setStorage(String fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public static void add(String fruit, Integer quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static void subtract(String fruit, Integer quantity) {
        if (storage.getOrDefault(fruit, 0) < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in storage");
        }

        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);
    }
}
