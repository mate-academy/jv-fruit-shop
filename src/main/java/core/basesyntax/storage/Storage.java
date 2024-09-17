package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> inventory = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        inventory.merge(fruit, quantity, Integer::sum);
    }

    public void removeFruit(String fruit, int quantity) {
        inventory.merge(fruit, -quantity, Integer::sum);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
