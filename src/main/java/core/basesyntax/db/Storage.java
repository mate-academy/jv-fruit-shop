package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> inventory;

    public Storage() {
        inventory = new HashMap<>();
    }

    public void updateFruitQuantity(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }

    public int getFruitQuantity(String fruit) {
        return inventory.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
