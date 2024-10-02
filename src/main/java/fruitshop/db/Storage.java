package fruitshop.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public void put(String fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    public Integer getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
