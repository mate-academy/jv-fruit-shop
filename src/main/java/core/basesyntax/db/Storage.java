package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    public static final HashMap<String, Integer> FRUIT_STORAGE = new HashMap<>();

    public static int get(String fruit) {
        return Storage.FRUIT_STORAGE.getOrDefault(fruit, 0);
    }

    public void put(String fruit, Integer quantity) {
        Storage.FRUIT_STORAGE.put(fruit, quantity);
    }
}
