package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, String> storage = new HashMap<>();

    @Override
    public boolean update(String fruit, String quantity) {
        String result = storage.put(fruit, quantity);
        return result != null && result.equals(quantity);
    }

    @Override
    public Map<String, String> snapshot() {
        return Map.copyOf(storage);
    }

    @Override
    public String get(String key) {
        return storage.get(key);
    }
}
