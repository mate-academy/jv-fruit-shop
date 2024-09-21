package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = storage.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Insufficient stock for " + fruit);
        }
        storage.put(fruit, currentQuantity - quantity);
    }

    public int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public void updateFruit(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}

