package core.basesyntax.db;

import java.util.LinkedHashMap;
import java.util.Map;

public final class Storage {
    private static final Map<String, Integer> FRUITS = new LinkedHashMap<>();

    private Storage() {
    }

    public static void put(String fruit, int quantity) {
        validateFruit(fruit);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        FRUITS.put(fruit, quantity);
    }

    public static int getQuantity(String fruit) {
        validateFruit(fruit);
        return FRUITS.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAll() {
        return new LinkedHashMap<>(FRUITS);
    }

    public static void clear() {
        FRUITS.clear();
    }

    private static void validateFruit(String fruit) {
        if (fruit == null || fruit.isBlank()) {
            throw new IllegalArgumentException("Fruit cannot be null or blank");
        }
    }
}
