package db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public void put(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public List<String> getFruits() {
        return storage.keySet().stream().toList();
    }

    public int getTotalQuantity() {
        return storage.values().stream().reduce(0, Integer::sum);
    }
}
