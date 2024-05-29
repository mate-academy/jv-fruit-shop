package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> storage = new HashMap<>();

    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) - quantity);
    }

    public int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
