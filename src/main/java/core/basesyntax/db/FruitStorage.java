package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private Map<String, Integer> fruitQuantities;

    public FruitStorage() {
        this.fruitQuantities = new HashMap<>();
    }

    public void updateQuantity(String fruit, int quantity) {
        fruitQuantities.put(fruit, fruitQuantities.getOrDefault(fruit, 0) + quantity);
    }

    public Map<String, Integer> getFruitQuantities() {
        return fruitQuantities;
    }
}
