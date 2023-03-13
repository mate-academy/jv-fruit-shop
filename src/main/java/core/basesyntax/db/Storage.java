package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final String[] DEFAULT_TITLES = {"fruit", "quantity"};
    private static Map<String, Integer> fruits = new HashMap<>();

    public static void change(String fruit, Integer amount) {
        fruits.put(fruit,Storage.fruits.get(fruit) + amount);
    }

    public static Map<String, Integer> getFruits() {
        return fruits;
    }
}
