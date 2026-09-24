package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String,Integer> storage;

    public Storage() {
        this.storage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    public void addToStorage(String key, Integer value) {
        storage.put(key, value);
    }

    Integer getFromStorage(String key) {
        return storage.get(key);
    }
}
