package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruits = new HashMap<>();

    public void add(String fruit, int quantity) {
        fruits.put(fruit, fruits.getOrDefault(fruit, 0) + quantity);
    }

    public void remove(String fruit, int quantity) {
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        int newQuantity = currentQuantity - quantity;

        if (newQuantity < 0) {
            throw new RuntimeException(
                    "Not enough " + fruit + " in storage. Available: "
                            + currentQuantity + ", requested: " + quantity
            );
        }

        fruits.put(fruit, newQuantity);
    }

    public void set(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }

    public Map<String, Integer> getAll() {
        return fruits;
    }
}
