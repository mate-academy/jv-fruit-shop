package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    public void addFruit(Fruit fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Map<Fruit, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
