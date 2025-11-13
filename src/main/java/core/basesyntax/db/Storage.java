package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static int getFruitQuantity(String fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit name cannot be null");
        }
        return fruits.getOrDefault(fruit, 0);
    }

    public static void setFruitQuantity(String fruit, int quantity) {
        if (fruit == null || quantity < 0) {
            throw new IllegalArgumentException(
            "Fruit name cannot be null and quantity must be non-negative");
        }
        fruits.put(fruit, quantity);
    }

    public static Map<String, Integer> getAllFruits() {
        return Map.copyOf(fruits);
    }
}
