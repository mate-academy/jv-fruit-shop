package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void decreaseFruitQuantity(String fruitName, Integer quantity) {
        if (storage.containsKey(fruitName)) {
            storage.put(fruitName, storage.get(fruitName) - quantity);
        } else {
            storage.put(fruitName, -quantity);
        }
    }

    public static void increaseFruitQuantity(String fruit, Integer quantity) {
        if (storage.containsKey(fruit)) {
            storage.put(fruit, storage.get(fruit) + quantity);
        } else {
            storage.put(fruit, quantity);
        }
    }

    public static Map<String, Integer> getAll() {
        Map<String, Integer> result = new HashMap<>();
        result.putAll(storage);
        return result;
    }
}

