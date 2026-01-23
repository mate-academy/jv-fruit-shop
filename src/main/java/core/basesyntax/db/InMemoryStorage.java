package core.basesyntax.db;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryStorage implements Storage {
    private final Map<String, Integer> storage = new LinkedHashMap<>();

    @Override
    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(new LinkedHashMap<>(storage));
    }

    @Override
    public int getQuantity(String fruit) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name must not be null or empty");
        }
        String key = fruit.trim().toLowerCase();
        return storage.getOrDefault(key, 0);
    }

    @Override
    public void putQuantity(String fruit, int qty) {
        if (fruit == null || fruit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name must not be null or empty");
        }
        if (qty < 0) {
            throw new IllegalArgumentException("Quantity must be non-negative");
        }
        String key = fruit.trim().toLowerCase();
        storage.put(key, qty);
    }
}
