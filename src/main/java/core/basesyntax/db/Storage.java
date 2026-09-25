package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String,Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return Map.copyOf(storage);
    }

    public void addToStorage(String key, Integer value) {
        storage.put(key, value);
    }

    public Integer getFromStorage(String key) {
        return storage.get(key);
    }
}
