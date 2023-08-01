package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> storageFruits;

    public Storage() {
        storageFruits = new HashMap<>();
    }

    public Map<String, Integer> getStorageFruits() {
        return storageFruits;
    }
}
