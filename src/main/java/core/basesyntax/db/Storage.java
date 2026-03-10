package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> FRUIT_STORAGE = new HashMap<>();

    public static void put(String fruit, int quantity) {
        FRUIT_STORAGE.put(fruit, quantity);
    }

    public static Map<String, Integer> getAll() {
        return Map.copyOf(FRUIT_STORAGE);
    }
}
