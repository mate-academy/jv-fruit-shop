package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String,Integer> fruits = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        if (!fruits.containsKey(fruit) || fruits.get(fruit) < quantity) {
            throw new IllegalArgumentException("Недостатньо " + fruit + "в наявності");
        } else {
            fruits.put(fruit, fruits.get(fruit) - quantity);
        }
    }

    public static Map<String,Integer> getFruits() {
        return fruits;
    }
}
