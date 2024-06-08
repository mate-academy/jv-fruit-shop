package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Integer getFruitQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static void setFruitQuantity(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public static Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}

