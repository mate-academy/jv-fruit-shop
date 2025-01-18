package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> inventory = new HashMap<>();

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
