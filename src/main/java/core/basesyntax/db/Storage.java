package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();
    private static final int INITIAL_QUANTITY = 0;

    public static void addFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, INITIAL_QUANTITY) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        if (fruits.getOrDefault(fruit, INITIAL_QUANTITY) < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
