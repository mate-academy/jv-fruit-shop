package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> storage = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        if (storage.containsKey(fruit)) {
            storage.put(fruit, storage.get(fruit) - quantity);
        }
    }

    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
