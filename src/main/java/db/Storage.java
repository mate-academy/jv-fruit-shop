package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void put(String name, Integer amount) {
        fruits.put(name, amount);
    }

    public static Integer get(String name) {
        return fruits.get(name);
    }
}
