package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruits = new HashMap<>();

    public void add(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Integer get(String fruit) {
        return fruits.get(fruit);
    }

    public Map<String, Integer> getAll() {
        return new HashMap<>(fruits);
    }
}
