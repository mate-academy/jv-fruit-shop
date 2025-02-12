package core.basesyntax.services;

import java.util.HashMap;
import java.util.Map;

public class StorageServiceImp implements StorageService {
    private static class Storage {
        static final Map<String, Integer> fruits = new HashMap<>();
    }

    @Override
    public void add(String fruit, int quantity) {
        if (fruit != null) {
            Storage.fruits.put(fruit, Storage.fruits.getOrDefault(fruit, 0) + quantity);
        }
    }

    @Override
    public void remove(String fruit, int quantity) {
        if (fruit == null || !Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("Fruit not found in storage: " + fruit);
        }
        int currentQuantity = Storage.fruits.get(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage to remove " + quantity);
        }
        Storage.fruits.put(fruit, currentQuantity - quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruits.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(Storage.fruits);
    }
}
