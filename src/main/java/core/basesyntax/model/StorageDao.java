package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public class StorageDao {
    public static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String key, Integer value) {
        if (storage.containsKey(key)) {
            storage.put(key, storage.get(key) + value);
        } else {
            storage.put(key, value);
        }
    }
}
