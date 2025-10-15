package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitDB {
    private static final Map<String, Integer> fruits = new HashMap<>();

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
