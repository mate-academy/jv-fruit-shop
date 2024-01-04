package dao;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Storage {
    private static int DEFAULT_VALUE = 0;
    private final Map<String, Integer> storage = new HashMap<>();

    public void put(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public int get(String fruit) {
        return storage.getOrDefault(fruit, DEFAULT_VALUE);
    }

    public Map<String, Integer> getAllFruitsWithQuantity() {
        return new HashMap<>(storage);
    }

    public void merge(String fruit, int quantity,
                      BiFunction<? super Integer,
                              ? super Integer, ? extends Integer> remappingFunction) {
        storage.merge(fruit, quantity, remappingFunction);
    }
}
