package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static void put(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAll() {
        return fruitStorage;
    }
}
