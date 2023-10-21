package core.basesyntax.dao;

import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final Map<String, Integer> fruits = new HashMap<>();

    public static Map<String, Integer> getFruits() {
        Map<String, Integer> fruitsCopy = new HashMap<>();
        for (String key : fruits.keySet()) {
            fruitsCopy.put(key, fruits.get(key));

        }
        return fruitsCopy;
    }

    @Override
    public void add(String name, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Cannot add such quantity: " + quantity);
        }
        int currentAmount = fruits.getOrDefault(name, 0);
        fruits.put(name, currentAmount + quantity);
    }

    @Override
    public void remove(String name, int quantity) {
        if (fruits.get(name) < quantity) {
            throw new RuntimeException("Not enough " + name + " to purchase");
        }
        fruits.put(name, fruits.get(name) - quantity);
    }

    @Override
    public void set(String name, int quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Cannot put such quantity: " + quantity);
        }
        fruits.put(name, quantity);
    }
}
