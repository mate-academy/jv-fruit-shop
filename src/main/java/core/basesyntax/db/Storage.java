package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> inventory;

    public Storage() {
        inventory = new HashMap<>();
    }

    public int getQuantity(String fruit) {
        return inventory.getOrDefault(fruit, 0);
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
