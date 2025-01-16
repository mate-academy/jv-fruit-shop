package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();
    private static final int DEFAULT_QUANTITY = 0;

    public void balance(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public void purchase(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        if (currentQuantity < quantity) {
            throw new IllegalStateException("Not enough " + fruit + " in storage");
        }
        fruits.put(fruit, currentQuantity - quantity);
    }

    public void returnFruit(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        fruits.put(fruit, currentQuantity + quantity);
    }

    public void supply(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
        fruits.put(fruit, currentQuantity + quantity);
    }

    public Map<String, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
