package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> STORAGE = new HashMap<>();

    public static void put(String fruit, int quantity) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        STORAGE.put(fruit, quantity);
    }

    public static int get(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
        return STORAGE.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getStorage() {
        return new HashMap<>(STORAGE);
    }
}
