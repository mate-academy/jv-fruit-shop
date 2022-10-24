package core.basesyntax.db;

import java.util.Map;
import java.util.stream.Stream;

public class StorageDao {
    public void add(String key, Integer value) {
        Storage.fruitStorage.put(key, value);
    }

    public Integer getValue(String key) {
        return Storage.fruitStorage.get(key);
    }

    public void setValue(String key, Integer newValue) {
        Storage.fruitStorage.replace(key, newValue);
    }

    public Stream<Map.Entry<String, Integer>> getStorageStream() {
        return Storage.fruitStorage.entrySet().stream();
    }
}
