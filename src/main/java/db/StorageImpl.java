package db;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {

    private final Map<String,Integer> inventory = new HashMap<>();

    public void set(String fruit, Integer quantity) {
        inventory.put(fruit, quantity);
    }

    public void add(String fruit, Integer quantity) {
        inventory.put(fruit,inventory.getOrDefault(fruit, 0) + quantity);
    }

    public void remove(String fruit, Integer quantity) {
        int current = inventory.getOrDefault(fruit,0);
        if (current < quantity) {
            throw new RuntimeException("Not enough stock for: " + fruit);
        }
        inventory.put(fruit, current - quantity);
    }

    public Map<String, Integer> getAllData() {
        return new HashMap<>(inventory);
    }
}
