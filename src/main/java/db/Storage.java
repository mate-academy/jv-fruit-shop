package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> map = new HashMap<>();

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void put(String fruit, Integer amount) {
        map.put(fruit, amount);
    }

    public static int getOrDefault(String fruit, Integer defaultValue) {
        return map.getOrDefault(fruit, defaultValue);
    }
}
