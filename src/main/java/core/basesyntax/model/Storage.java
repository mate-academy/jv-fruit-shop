package core.basesyntax.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        int currentQuantity = storage.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException(
                    "It is not possible to write off more items than are in stock for: "
                            + fruit);
        }
        storage.put(fruit, currentQuantity - quantity);
    }

    public static Map<String, Integer> getFullStorage() {
        return Collections.unmodifiableMap(storage);
    }
}
