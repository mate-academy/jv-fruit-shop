package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private final Map<String, Integer> fruits = new HashMap<>();

    public void set(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public int getQuantityByFruit(String fruitName) {
        return fruits.get(fruitName);
    }

    public void add(String fruit, int quantity) {
        fruits.merge(fruit, quantity, Integer::sum);
    }

    public void subtract(String fruit, int quantity) {
        fruits.merge(fruit, -quantity, Integer::sum);
    }

    public Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(fruits);
    }

}
