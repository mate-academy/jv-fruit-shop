package core.basesyntax.service.db;

import java.util.HashMap;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public void updateBalance(String fruit, int amount) {
        storage.put(fruit, amount);
    }

    @Override
    public void addSupply(String fruit, int amount) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + amount);
    }

    @Override
    public void purchaseFruit(String fruit, int amount) {
        if (storage.containsKey(fruit)) {
            int currentQuantity = storage.get(fruit);
            if (currentQuantity >= amount) {
                storage.put(fruit, currentQuantity - amount);
            } else {
                throw new RuntimeException("Not enough fruit in stock to complete the purchase.");
            }
        } else {
            throw new RuntimeException("No such fruit in stock.");
        }
    }

    @Override
    public void returnFruit(String fruit, int amount) {
        if (storage.containsKey(fruit)) {
            storage.put(fruit, storage.get(fruit) + amount);
        } else {
            throw new RuntimeException("Cannot return fruit that is not in stock.");
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
