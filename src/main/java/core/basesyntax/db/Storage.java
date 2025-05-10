package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String,Integer> fruits = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public static void removeFruit(String fruit, int quantity) {
        if (fruits.get(fruit) < 0 || !fruits.containsKey(fruit) || fruits.get(fruit) < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock");
        }
        fruits.put(fruit, fruits.get(fruit) - quantity);
    }
}
