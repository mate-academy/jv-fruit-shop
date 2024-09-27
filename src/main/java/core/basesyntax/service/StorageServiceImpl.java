package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getInventory() {
        return new HashMap<>(storage);
    }
}
