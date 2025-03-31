package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<String, Integer> fruitList = new HashMap<>();

    public static void add(String fruit, Integer amount) {
        fruitList.put(fruit, fruitList.getOrDefault(fruit, 0) + amount);
    }

    public static void remove(String fruit, Integer amount) {
        if (!fruitList.containsKey(fruit) || fruitList.get(fruit) < amount) {
            throw new IllegalArgumentException("There's not enough " + fruit + " in storage.");
        }
        fruitList.put(fruit, fruitList.get(fruit) - amount);
    }

    public static int getAmount(String fruit) {
        return fruitList.getOrDefault(fruit, 0);
    }

    public static Map<String, Integer> getAllFruit() {
        return new HashMap<>(fruitList);
    }
}
