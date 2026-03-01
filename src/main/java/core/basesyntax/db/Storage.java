package core.basesyntax.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static Map<String, Integer> getFruitStorage() {
        return Collections.unmodifiableMap(fruitStorage);
    }

    public static void put(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }
}
