package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();
    private static final int DEFAULT_QUANTITY = 0;

    public static void put(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public static int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, DEFAULT_QUANTITY);
    }
}
