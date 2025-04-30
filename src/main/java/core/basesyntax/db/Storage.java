package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruits = new HashMap<>();

    public int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit, 0);
    }

    public void addQuantity(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public void removeQuantity(String fruit, int quantity) {
        if (fruits.containsKey(fruit)) {
            int currentQuantity = fruits.get(fruit);
            if (currentQuantity >= quantity) {
                fruits.put(fruit, currentQuantity - quantity);
            } else {
                throw new IllegalArgumentException("Not enough " + fruit + " in storage.");
            }
        } else {
            throw new IllegalArgumentException("Fruit " + fruit + " not found in storage.");
        }
    }

    public boolean containsFruit(String fruit) {
        return fruits.containsKey(fruit);
    }

    public Map<String, Integer> getFruitQuantities() {
        return new HashMap<>(fruits);
    }
}
