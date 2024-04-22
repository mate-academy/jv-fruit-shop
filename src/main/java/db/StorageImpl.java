package db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StorageImpl implements Storage {
    private static Map<String, Integer> data = new HashMap<>();

    public Integer getValue(String key) {
        return data.get(key);
    }

    public void setValue(String key, Integer value) {
        data.put(key, value);
    }

    public Set<String> getKeys() {
        return data.keySet();
    }
}
