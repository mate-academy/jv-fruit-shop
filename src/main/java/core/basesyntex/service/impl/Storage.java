package core.basesyntex.service.impl;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public static void updateStorage(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(storage);
    }
}
