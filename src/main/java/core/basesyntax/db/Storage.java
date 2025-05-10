package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void modifyFruitStorage(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
        if (fruits.get(fruit) < 0) {
            throw new IllegalStateException("Stock for fruit " + fruit + " cannot be negative.");
        }
    }

    public static int getFruitQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
