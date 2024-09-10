package core.basesyntax.db.impl;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> storage = new HashMap<>();

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }

    @Override
    public int getQuantity(String key) {
        return storage.getOrDefault(key, 0);
    }

    @Override
    public void addEntry(String key, Integer value) {
        storage.put(key, value);
    }

    @Override
    public void removeEntry(String key) {
        storage.remove(key);
    }
}
