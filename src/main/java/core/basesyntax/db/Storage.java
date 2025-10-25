package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitsStorage = new HashMap<>();

    public static void putFruitQuantity(String fruit, int quantity) {
        fruitsStorage.put(fruit, quantity);
    }

    public static int getFruitQuantity(String fruit) {
        return fruitsStorage.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllFruitsQuantities() {
        return Collections.unmodifiableMap(fruitsStorage);
    }
}
