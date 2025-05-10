package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    @Override
    public void addFruit(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be null or empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        Storage.addFruit(fruit, quantity);
    }

    @Override
    public void removeFruit(String fruit, int quantity) {
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be null or empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        Storage.removeFruit(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return Storage.getAllFruits();
    }
}
