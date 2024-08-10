package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public void add(String fruitName, int quantity) {
        fruits.put(fruitName, quantity);
    }

    public int get(String fruitName) {
        return fruits.get(fruitName);
    }

    public boolean contains(String fruitName) {
        return fruits.containsKey(fruitName);
    }
}
