package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void subtract(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) - quantity);
    }

    public static Map<String, Integer> getAll() {
        return new HashMap<>(fruits);
    }
}
