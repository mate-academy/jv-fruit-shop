package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String fruit, Integer amount) {
        fruits.put(fruit, amount);
    }

    public static int getOrDefault(String key, int defaultValue) {
        return fruits.getOrDefault(key, defaultValue);
    }

    public static Integer get(String fruit) {
        return fruits.get(fruit);
    }

    public static Map<String, Integer> getMap() {
        return fruits;
    }
}
