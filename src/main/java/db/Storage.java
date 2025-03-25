package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitList = new HashMap<>();

    public Map<String, Integer> getFruitList() {
        return fruitList;
    }

    public void add(String fruit, Integer amount) {
        fruitList.put(fruit, fruitList.getOrDefault(fruit, 0) + amount);
    }

    public void remove(String fruit, Integer amount) {
        if (!fruitList.containsKey(fruit) || fruitList.get(fruit) < amount) {
            throw new RuntimeException("There's not enough " + fruit + " in storage.");
        }
        fruitList.put(fruit, fruitList.get(fruit) - amount);
    }

    public int getAmount(String fruit) {
        return fruitList.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getAllFruit() {
        return new HashMap<>(fruitList);
    }
}
