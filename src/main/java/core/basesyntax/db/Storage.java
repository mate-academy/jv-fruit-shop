package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(storage);
    }
}
