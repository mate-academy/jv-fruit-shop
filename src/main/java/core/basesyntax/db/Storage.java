package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void setQuantity(String fruit, int fruitQuantity) {
        storage.put(fruit, fruitQuantity);
    }

    public static void merge(final String fruit, final int fruitQuantity) {
        storage.merge(fruit, fruitQuantity, Integer::sum);
    }

    public static int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getStorage() {
        return Collections.unmodifiableMap(storage);
    }
}
