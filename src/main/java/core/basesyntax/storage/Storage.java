package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruits = new HashMap<>();

    public Map<String, Integer> getFruits() {
        return fruits;
    }

    public void put(String fruit, Integer quantity) {
        fruits.put(fruit, quantity);
    }

    public void plus(String fruit, Integer quantity) {
        Integer initialAmount = fruits.get(fruit);
        if (initialAmount == null) {
            throw new RuntimeException("Can't purchase not existent fruit");
        }
        if (quantity > initialAmount) {
            throw new RuntimeException("Can't remove more than there is in stock");
        }
        fruits.put(fruit, initialAmount + quantity);
    }
}
