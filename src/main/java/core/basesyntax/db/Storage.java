package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    // Use a private map to store the fruits
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        return Collections.unmodifiableMap(fruits);
    }

    public static void addFruit(String name, int quantity) {
        if (name == null || name.isEmpty() || quantity < 0) {
            throw new IllegalArgumentException("Invalid fruit name or quantity");
        }
        fruits.put(name, quantity);
    }
}

