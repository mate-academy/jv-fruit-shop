package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruits = new HashMap<>();

    public static void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void remove(String fruit, int quantity) {
        fruits.remove(fruit, fruits.getOrDefault(fruit, 0) - quantity);
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }
}

