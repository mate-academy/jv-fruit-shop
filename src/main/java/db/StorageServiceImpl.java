package db;

import java.util.HashMap;
import java.util.Map;

public class StorageServiceImpl implements StorageService {

    private final Map<String, Integer> storage = new HashMap<>();

    @Override
    public Map<String, Integer> getStorageCopy() {
        return new HashMap<>(storage);
    }

    @Override
    public Integer put(String fruit, int quantity) {
        return storage.put(fruit, quantity);
    }

    @Override
    public int get(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }
}
