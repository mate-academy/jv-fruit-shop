package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static int get(String fruit) {
        return Storage.fruitStorage.get(fruit);
    }

    public static void set(String fruit, Integer quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }
}
