package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative: " + quantity);
        }
        inventory.merge(fruit, quantity, Integer::sum);
    }

    public void removeFruit(String fruit, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to remove cannot be negative: "
                    + quantity);
        }
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Insufficient quantity to remove: " + fruit);
        }
        inventory.merge(fruit, -quantity, Integer::sum);
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }

    public int getQuantity(String fruit) {
        return inventory.getOrDefault(fruit, 0);
    }
}

