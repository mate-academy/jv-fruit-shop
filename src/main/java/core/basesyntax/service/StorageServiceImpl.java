package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private final Map<String, Integer> fruitStorage = Storage.getFruitStorage();

    @Override
    public void setBalance(String fruit, int quantity) {
        isNegative(quantity);
        fruitStorage.put(fruit, quantity);
        updateStorage(fruitStorage);
    }

    @Override
    public void addFruit(String fruit, int quantity) {
        isNegative(quantity);
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) + quantity);
        updateStorage(fruitStorage);
    }

    @Override
    public void removeFruit(String fruit, int quantity) {
        isNegative(quantity);
        if (fruitStorage.getOrDefault(fruit, 0) < quantity) {
            throw new RuntimeException("Not enough fruit in stock");
        }
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) - quantity);
        updateStorage(fruitStorage);
    }

    private void isNegative(int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Quantity can't be negative");
        }
    }

    private void updateStorage(Map<String, Integer> fruitStorage) {
        Storage.setFruitStorage(fruitStorage);
    }
}
