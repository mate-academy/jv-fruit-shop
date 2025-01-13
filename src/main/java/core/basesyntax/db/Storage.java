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
        if (inventory.get(fruit) >= quantity) {
            inventory.put(fruit, inventory.get(fruit) - quantity);
        }
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
