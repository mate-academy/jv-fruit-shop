package core.basesyntax.service;

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
            throw new IllegalArgumentException("Not enough quantity in storage");
        }
        storage.put(fruit, currentQuantity - quantity);
    }

    public int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(storage);
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
