package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
<<<<<<< HEAD
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
=======
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        storage.put(fruit, storage.get(fruit) - quantity);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(storage);
>>>>>>> a2ecd4f4d0021899123c500a6b2358d573ff5486
    }
}
