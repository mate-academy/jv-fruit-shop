package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void add(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public void set(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }

    public void remove(String fruit, int quantity) {
        if (!inventory.containsKey(fruit)) {
            throw new IllegalArgumentException("Fruit " + fruit + " not found in inventory");
        }

        int currentQuantity = inventory.get(fruit);

        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Insufficient quantity of " + fruit
                    + " in inventory. " + "Current quantity: " + currentQuantity);
        }

        inventory.put(fruit, currentQuantity - quantity);

    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
