package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> inventory;

    public Storage() {
        inventory = new HashMap<>();
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
