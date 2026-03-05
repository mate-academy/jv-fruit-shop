package fruitshop.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static int getQuantity(String fruit) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }

        return fruits.getOrDefault(fruit, 0);
    }

    public static void setQuantity(String fruit, int quantity) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }
        fruits.put(fruit, quantity);
    }

    public static void incrementQuantity(String fruit, int delta) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }
        int current = fruits.getOrDefault(fruit, 0);
        fruits.put(fruit, current + delta);
    }

    public static void decrementQuantity(String fruit, int delta) {
        if (fruit == null) {
            throw new IllegalArgumentException("Fruit cannot be null");
        }
        int current = fruits.getOrDefault(fruit, 0);
        fruits.put(fruit, current - delta);
    }

    public static Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(fruits));
    }

    public static void clear() {
        fruits.clear();
    }
}
