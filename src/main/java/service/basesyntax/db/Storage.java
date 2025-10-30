package service.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public void put(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public boolean contains(String fruit) {
        return storage.containsKey(fruit);
    }

    public Map<String, Integer> getStorage() {
        return Map.copyOf(storage); // защищённое чтение
    }
}
