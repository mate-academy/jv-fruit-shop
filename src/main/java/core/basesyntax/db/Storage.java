package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> inventory = new HashMap<>();

    public static void updateInventory(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public static Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }

    public static void setInventory(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }
}
