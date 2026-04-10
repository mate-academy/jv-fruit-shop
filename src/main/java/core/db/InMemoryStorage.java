package core.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryStorage implements Storage {
    private static final Map<String, Integer> storage = new HashMap<>();
    
    @Override
    public void put(String key, Integer value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key is cant be null or empty");
        }
        if (value == null || value < 0) {
            throw new IllegalArgumentException("value cant be null or negative");
        }
        storage.put(key, value);
    }
    
    @Override
    public Optional<Integer> getQuantity(String fruit) {
        return Optional.ofNullable(storage.get(fruit));
    }
    
    @Override
    public boolean contains(String fruit) {
        if (fruit == null || fruit.isEmpty()) {
            throw new IllegalArgumentException("key is null or empty");
        }
        return storage.containsKey(fruit);
    }
    
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
