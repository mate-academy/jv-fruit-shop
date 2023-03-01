package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> map = new HashMap<>();

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void put(String name, Integer amount) {
        map.put(name, amount);
    }

    public static int getOrDefault(String fruit, int defaultValue) {
        return map.getOrDefault(fruit, defaultValue);
    }
}
