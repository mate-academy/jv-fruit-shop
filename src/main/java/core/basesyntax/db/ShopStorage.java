package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class ShopStorage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public void add(String key, int value) {
        storage.put(key, value);
    }

    public int get(String key) {
        return storage.get(key);
    }

    public int getOrDefault(String key, int usual) {
        return storage.getOrDefault(key, usual);
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    public void update(String key, int value) {
        storage.put(key, value);
    }
}
