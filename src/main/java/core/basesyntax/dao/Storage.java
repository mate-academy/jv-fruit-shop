package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final HashMap<String,Integer> map = new HashMap<>();

    public static Map<String,Integer> getMap() {
        return map;
    }

    public static void put(String name, int quantity) {
        map.put(name, quantity);
    }

    public static int getOrDefault(String fruitName, int defaultValue) {
        return map.getOrDefault(fruitName, defaultValue);
    }
}
