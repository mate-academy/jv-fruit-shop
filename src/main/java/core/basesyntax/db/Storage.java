package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Integer put(String key, Integer value) {
        return fruits.put(key, value);
    }

    public static Integer getOrDefault(Object key, Integer defaultValue) {
        return fruits.getOrDefault(key, defaultValue);
    }

    public static Map<String, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
