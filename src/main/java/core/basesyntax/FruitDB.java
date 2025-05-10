package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitDB {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void add(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public void subtract(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) - quantity);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

