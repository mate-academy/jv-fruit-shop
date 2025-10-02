package db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private static final Map<String, Integer> FRUIT_STORAGE = new HashMap<>();

    private Storage() {
    }

    public static int getQuantity(String fruit) {
        return FRUIT_STORAGE.getOrDefault(fruit, 0);
    }

    public static void setQuantity(String fruit, int quantity) {
        FRUIT_STORAGE.put(fruit, quantity);
    }

    public static void addQuantity(String fruit, int quantity) {
        FRUIT_STORAGE.merge(fruit, quantity, Integer::sum);
    }

    public static Map<String, Integer> getSnapshot() {
        return Collections.unmodifiableMap(FRUIT_STORAGE);
    }
}
