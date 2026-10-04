package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruits = new HashMap<>();

    public void put(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Integer getOrDefault(String fruit, Integer defaultValue) {
        return fruits.getOrDefault(fruit, defaultValue);
    }

    public Map<String, Integer> getAll() {
        return fruits;
    }
}
