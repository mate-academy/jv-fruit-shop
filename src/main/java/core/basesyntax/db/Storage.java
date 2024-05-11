package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruitsInventory = new HashMap<>();

    public Map<String, Integer> getFruitsInventory() {
        return fruitsInventory;
    }

    private int getFruitsInventory(String fruit) {
        return fruitsInventory.getOrDefault(fruit, 0);
    }

    public void setFruitsQuantity(String fruit, int quantity) {
        fruitsInventory.put(fruit, quantity);
    }

    public void increaseFruitsQuantity(String fruit, int quantity) {
        fruitsInventory.put(fruit, getFruitsInventory(fruit) + quantity);
    }

    public void decreaseFruitsQuantity(String fruit, int quantity) {
        fruitsInventory.put(fruit, getFruitsInventory(fruit) - quantity);
    }
}
