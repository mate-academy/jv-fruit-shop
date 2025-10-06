package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> FRUITS = new HashMap<>();

    private Storage() {
    }

    public static void setQuantity(String fruit, int quantity) {
        validate(fruit);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        FRUITS.put(fruit, quantity);
    }

    public static void addQuantity(String fruit, int quantity) {
        validate(fruit);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        FRUITS.merge(fruit, quantity, Integer::sum);
    }

    public static int getQuantity(String fruit) {
        validate(fruit);
        return FRUITS.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getSnapshot() {
        return Collections.unmodifiableMap(new HashMap<>(FRUITS));
    }

    private static void validate(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or empty");
        }
    }
}
