package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    // Use a private map to store the fruits
    private static final Map<String, Integer> fruits = new HashMap<>();

    // Provide a public method to get an unmodifiable view of the fruits map
    public static Map<String, Integer> getFruits() {
        return Collections.unmodifiableMap(fruits);
    }

    // Provide a public method to add a fruit
    public static void addFruit(String name, int quantity) {
        if (name == null || name.isEmpty() || quantity < 0) {
            throw new IllegalArgumentException("Invalid fruit name or quantity");
        }
        fruits.put(name, quantity);
    }

    // Provide a public method to remove a fruit
    public static void removeFruit(String name) {
        fruits.remove(name);
    }

    // Provide a public method to get the quantity of a specific fruit
    public static int getFruitQuantity(String name) {
        return fruits.getOrDefault(name, 0);
    }
}

