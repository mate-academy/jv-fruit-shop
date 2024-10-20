package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    Map<String, Integer> fruits;

    public FruitStorage() {
        this.fruits = new HashMap<>();
    }

    public void addFruit(String fruitName, int quantity) {
        fruits.put(fruitName, quantity);
    }

    public void removeFruit(String fruitName, int quantity) {
        if (!fruits.containsKey(fruitName)) {
            throw new IllegalArgumentException("Fruit is not found: "+ fruitName);
        }
        int currentQuantity = fruits.get(fruitName);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruitName + " in stock");
        }
        fruits.put(fruitName,currentQuantity - quantity);
    }

    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
