package core.basesyntax.db;

import core.basesyntax.InsufficientStockException;
import core.basesyntax.ProductIsAbsentException;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> storage = new HashMap<>();

    public void add(String key, Integer value) {
        if (storage.containsKey(key)) {
            update(key, value);
        } else {
            storage.put(key, value);
        }
    }

    public void update(String key, Integer value) {
        storage.put(key, storage.get(key) + value);
    }

    public void remove(String key, Integer value) {
        if (storage.containsKey(key)) {
            if (storage.get(key) >= value) {
                storage.put(key, storage.get(key) - value);
            } else {
                throw new InsufficientStockException("Not enough product in stock");
            }
        } else {
            throw new ProductIsAbsentException("Such product wasn't found");
        }
    }

    public Integer get(String key) {
        Integer value = storage.get(key);
        return value;
    }

}
