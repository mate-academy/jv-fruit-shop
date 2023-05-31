package core.basesyntax.db;

import java.util.HashMap;

public class Storage {
    public static final HashMap<String, Integer> fruitStorage = new HashMap<>();

    public static void put(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return Storage.fruitStorage.getOrDefault(fruit, 0);
    }
}
