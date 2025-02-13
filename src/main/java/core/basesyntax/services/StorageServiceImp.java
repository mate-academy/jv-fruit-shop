package core.basesyntax.services;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageServiceImp implements StorageService {
    @Override
    public void add(String fruit, int quantity) {
        if (fruit == null || quantity < 0) {
            throw new IllegalArgumentException("Fruit name cannot be null and "
                    + "quantity must be non-negative");
        }
        Storage.fruitMap.put(fruit, Storage.fruitMap.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public void remove(String fruit, int quantity) {
        if (fruit == null || !Storage.fruitMap.containsKey(fruit)) {
            throw new RuntimeException("Fruit not found in storage: " + fruit);
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to remove cannot be negative");
        }
        int currentQuantity = Storage.fruitMap.get(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage to remove " + quantity);
        }
        Storage.fruitMap.put(fruit, currentQuantity - quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit name cannot be null");
        }
        return Storage.fruitMap.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Map.copyOf(Storage.fruitMap);
    }
}
