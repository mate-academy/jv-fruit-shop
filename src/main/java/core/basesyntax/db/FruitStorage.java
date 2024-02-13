package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private final Map<String, Integer> fruitInventory;

    public FruitStorage() {
        this.fruitInventory = new HashMap<>();
    }

    public void addFruit(String fruit, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruit, 0);
        fruitInventory.put(fruit, currentQuantity + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Invalid transaction:"
                    + " quantity cannot be negative after purchase");
        }
        fruitInventory.put(fruit, currentQuantity - quantity);
    }

    public Map<String, Integer> getFruitInventory() {
        return new HashMap<>(fruitInventory);
    }
}
