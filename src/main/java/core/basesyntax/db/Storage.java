package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<String, Integer> inventory;
    private static final int DEFAULT_INVENTORY_VALUE = 0;

    private Storage() {
        inventory = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public int getQuantity(String fruit) {
        return inventory.getOrDefault(fruit, DEFAULT_INVENTORY_VALUE);
    }

    public void setQuantity(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }

    public void addQuantity(String fruit, int quantity) {
        inventory.put(fruit, getQuantity(fruit) + quantity);
    }

    public void subtractQuantity(String fruit, int quantity) {
        inventory.put(fruit, getQuantity(fruit) - quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
