package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Integer getFruit(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public static void putFruit(String fruit, Integer amount) {
        fruits.put(fruit, amount);
    }

    public static Map<String, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
