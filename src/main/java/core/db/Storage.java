package core.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    public static int get(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public static void put(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(fruitStorage);
    }
}
