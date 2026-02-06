package basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void clear() {
        storage.clear();
    }

    public static Map<String, Integer> getFruits() {
        return storage;
    }
}
