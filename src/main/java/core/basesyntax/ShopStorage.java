package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class ShopStorage {
    private static ShopStorage instance;
    private Map<String, Integer> fruits;

    ShopStorage() {
        fruits = new HashMap<>();
    }

    public static ShopStorage getInstance() {
        if (instance == null) {
            instance = new ShopStorage();
        }
        return instance;
    }

    public void setFruitQuantity(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Map<String, Integer> getAllFruits() {
        return fruits;
    }

    public void updateFruitQuantity(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }
}

