package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> STORAGE = new HashMap<>();

    public static void put(String fruit, int quantity) {
        STORAGE.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return STORAGE.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getStorage() {
        return STORAGE;
    }
}
