package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruits.merge(fruit, quantity, Integer::sum);
    }

    public static void removeFruit(String fruit, int quantity) {
        Integer currentQuantity = fruits.get(fruit);
        if (currentQuantity == null || currentQuantity < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage");
        }
        fruits.put(fruit, currentQuantity - quantity);
    }

    public static Map<String, Integer> getAllFruits() {
        return Collections.unmodifiableMap(new HashMap<>(fruits));
    }
}
