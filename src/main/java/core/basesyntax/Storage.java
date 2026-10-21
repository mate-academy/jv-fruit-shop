package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruits = new HashMap<>();

    public void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public void remove(String fruit, int quantity) {
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }

    public void set(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Map<String, Integer> getAll() {
        return fruits;
    }
}
