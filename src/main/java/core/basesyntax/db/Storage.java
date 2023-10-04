package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    public static final HashMap<String, Integer> fruitStorage = new HashMap<>();
    private static final int DEFAULT_VALUE_FROM_STORAGE = 0;

    public static int get(String fruit) {
        return Storage.fruitStorage.getOrDefault(fruit, DEFAULT_VALUE_FROM_STORAGE);
    }

    public static void put(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }
}
