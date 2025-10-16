package core.basesyntax.db;

import java.util.Map;

public class FruitDB {
    private final Map<String, Integer> fruits;

    public FruitDB(Map<String, Integer> fruits) {
        this.fruits = fruits;
    }

    public void setQuantity(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public Integer getQuantity(String fruit) {
        return fruits.get(fruit);
    }

    public Map<String, Integer> getFruits() {
        return Map.copyOf(fruits);
    }
}
