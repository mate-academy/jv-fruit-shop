package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void put(String key, Integer value) {
        storage.put(key, value);
    }

    public static Integer get(String key) {
        return storage.get(key);
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
