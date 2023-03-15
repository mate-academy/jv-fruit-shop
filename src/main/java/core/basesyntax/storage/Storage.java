package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        return fruits;
    }

    public static void put(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public static void plus(String fruit, Integer quantity) {
        fruits.put(fruit, fruits.get(fruit) + quantity);
    }

    public static void minus(String fruit, Integer quantity) {
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }
}
