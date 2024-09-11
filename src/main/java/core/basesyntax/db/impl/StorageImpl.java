package core.basesyntax.db.impl;

import core.basesyntax.db.Storage;
import java.util.LinkedHashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> storage = new LinkedHashMap<>();

    @Override
    public Map<String, Integer> getStorage() {
        return new LinkedHashMap<>(storage);
    }

    @Override
    public int getQuantity(String key) {
        return storage.getOrDefault(key, 0);
    }

    @Override
    public void addEntry(String key, Integer value) {
        if (key == null) {
            throw new NullPointerException("Key can't be null");
        } else if (value == null) {
            throw new NullPointerException("Value can't be null");
        }
        storage.put(key, value);
    }

    @Override
    public void removeEntry(String key) {
        storage.remove(key);
    }
}
