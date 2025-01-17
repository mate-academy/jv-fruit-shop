package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();
    private static final int DEFAULT_QUANTITY = 0;

    public static void balance(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static void purchase(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        if (currentQuantity < quantity) {
            throw new IllegalStateException("Not enough " + fruit + " in storage");
        }
        fruits.put(fruit, currentQuantity - quantity);
    }

    public static void returnFruit(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        fruits.put(fruit, currentQuantity + quantity);
    }

    public static void supply(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        fruits.put(fruit, currentQuantity + quantity);
    }
}
