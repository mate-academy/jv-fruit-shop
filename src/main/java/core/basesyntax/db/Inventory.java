package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
