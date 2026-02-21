package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void mergeQuantity(String fruit, int quantity) {
        storage.merge(fruit, quantity, Integer::sum);
    }

    public static void putQuantity(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public static Integer getQuantity(String fruit) {
        return storage.get(fruit);
    }

    public static Map<String, Integer> getAll() {
        return Collections.unmodifiableMap(storage);
    }
}
