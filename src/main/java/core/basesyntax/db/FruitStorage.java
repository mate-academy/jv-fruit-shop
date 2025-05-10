package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private final Map<String, Integer> fruitInventory = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        fruitInventory.put(fruit, fruitInventory.getOrDefault(fruit, 0) + quantity);
    }

    public void substractFruit(String fruit, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in the inventory");
        }
        fruitInventory.put(fruit, currentQuantity - quantity);
    }

    public Map<String, Integer> getFruitInventory() {
        return new HashMap<>(fruitInventory);
    }
}

