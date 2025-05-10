package service;

import java.util.HashMap;
import java.util.Map;

public class StorageService {
    private final Map<String, Integer> fruitQuantities;

    public StorageService() {
        this.fruitQuantities = new HashMap<>();
    }

    public void addFruit(String fruit, int quantity) {
        fruitQuantities.put(fruit, fruitQuantities.getOrDefault(fruit, 0) + quantity);
    }

    public int getFruitQuantity(String fruit) {
        return fruitQuantities.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getFruitQuantities() {
        return new HashMap<>(fruitQuantities);
    }

    public void clearStorage() {
        fruitQuantities.clear();
    }
}
