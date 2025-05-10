package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage implements FruitStorage {
    private static final Map<String, Integer> fruits = new HashMap<>();

    @Override
    public void addFruit(String fruit, int quantity) {
        fruits.merge(fruit, quantity, Integer::sum);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    @Override
    public void updateFruitQuantity(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruits);
    }
}
