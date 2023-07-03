package db;

import java.util.HashMap;
import java.util.Map;

public class ShopStorageImpl implements ShopStorage {
    private final Map<String, Integer> fruitStorage;

    public ShopStorageImpl() {
        this.fruitStorage = new HashMap<>();
    }

    public void updateQuantity(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public int getQuantity(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitStorage;
    }
}
