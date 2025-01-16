package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> inventory = new HashMap<>();
    private static final int DEFAULT_INVENTORY_VALUE = 0;
    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public int getDefaultInventoryValue() {
        return DEFAULT_INVENTORY_VALUE;
    }
}
