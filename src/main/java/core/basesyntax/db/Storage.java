package core.basesyntax.db;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Storage {
    private static final Map<String, Integer> fruits = new ConcurrentHashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruits.merge(fruit, quantity, Integer::sum);
    }

    public static void removeFruit(String fruit, int quantity) {
        fruits.compute(fruit, (k, v) -> {
            if (v == null || v < quantity) {
                throw new RuntimeException("Not enough " + fruit + " in storage");
            }
            return v - quantity;
        });
    }

    public static Map<String, Integer> getAllFruits() {
        return Map.copyOf(fruits);
    }
}
