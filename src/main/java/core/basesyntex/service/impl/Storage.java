package core.basesyntex.service.impl;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public void updateStorage(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public Map<String, Integer> getAll() {
        return storage;
    }
}
