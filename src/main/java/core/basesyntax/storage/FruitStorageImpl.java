package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageImpl implements FruitStorage {
    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public void setFruitBalance(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public void removeFruit(String fruit, int quantity) {
        storage.merge(fruit, -quantity, (currentQuantity, delta) -> {
            int newQuantity = currentQuantity + delta;
            if (newQuantity < 0) {
                throw new IllegalArgumentException("Not enough " + fruit + "in storage");
            }
            return newQuantity;
        });
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return Map.copyOf(storage);
    }
}
