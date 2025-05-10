package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static final Map<String, Integer> storage = new HashMap<>();

    public static void add(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public static void update(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public static int get(String fruit) {
        return storage.get(fruit);
    }

    public static Map<String, Integer> getStorage() {
        return storage;
    }
}
