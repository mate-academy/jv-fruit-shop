package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> inventory = new HashMap<>();

    public static void setBalance(String fruit, int quantity) {
        inventory.put(fruit, quantity);
    }

    public static void supply(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public static void purchase(String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock");
        }
        inventory.put(fruit, currentQuantity - quantity);
    }

    public static void returnFruits(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }
}
