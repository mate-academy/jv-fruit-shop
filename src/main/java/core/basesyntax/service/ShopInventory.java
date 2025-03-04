package core.basesyntax.service;

import java.util.HashMap;
import java.util.Map;

public class ShopInventory {
    private static final int DEFAULT_MAP_VALUE = 0;

    private HashMap<String, Integer> inventory = new HashMap<>();

    public void setFruitQuantity(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }

    public void addFruitQuantity(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, DEFAULT_MAP_VALUE) + quantity);
    }

    public void deductFruitQuantity(String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, DEFAULT_MAP_VALUE);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough quantity to purchase. Current quantity is: "
                    + currentQuantity);
        }
        inventory.put(fruit, currentQuantity - quantity);
    }

    public Map<String, Integer> getFruitQuantity() {
        return inventory;
    }
}
