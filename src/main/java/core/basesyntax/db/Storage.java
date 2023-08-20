package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> storageFruits;

    public Storage() {
        storageFruits = new HashMap<>();
    }

    public boolean add(String key, Integer value) {
        storageFruits.put(key, value);
        return true;
    }

    public boolean clean() {
        storageFruits.clear();
        return storageFruits.isEmpty();
    }

    public Map<String, Integer> getStorageFruits() {
        return storageFruits;
    }
}
