package core.storage;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private Map<String, Integer> storage;

    public StorageImpl() {
        this.storage = new HashMap<>();
    }

    @Override
    public void add(String fruit, Integer quantity) {
        storage.put(fruit,
                (storage.get(fruit) == null ? quantity : storage.get(fruit) + quantity));
    }

    @Override
    public void removeFromStorage(String fruit, Integer quantity) {
        storage.put(fruit,
                (storage.get(fruit) == null ? quantity : storage.get(fruit) - quantity));
    }

    @Override
    public Map<String, Integer> getAllData() {
        return storage;
    }
}
