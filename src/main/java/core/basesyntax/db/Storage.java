package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void updateInventory(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit,0) + quantity);
    }

    public int getQuantity(String fruit) {
        return inventory.getOrDefault(fruit, 0);
    }

    public Map<String,Integer> getInventory() {
        return new HashMap<>(inventory);
    }
}
