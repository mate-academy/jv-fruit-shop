package core.basesyntax.data;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> inventory = new HashMap<>();

    public static void add(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) - quantity);
    }

    public static Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }
}
