package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruits = new HashMap<>();

    public Storage() {
    }

    public static void addFruit(String fruitName,Integer quantity) {
        fruits.put(fruitName, quantity);
    }

    public static Integer getQuantityBy(String fruitName) {
        return fruits.get(fruitName);
    }

    public static Map<String,Integer> getFruits() {
        return fruits;

    }
}
