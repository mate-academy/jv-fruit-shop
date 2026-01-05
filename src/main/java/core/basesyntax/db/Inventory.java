package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> fruitInventory = new HashMap<>();

    public void setFruitQuantity(String fruit, Integer quantity) {
        fruitInventory.put(fruit, quantity);
    }

    public Integer getFruitQuantity(String fruit) {
        Integer quantity = fruitInventory.get(fruit);
        if (quantity == null) {
            return 0;
        } else {
            return quantity;
        }
    }

    public Map<String, Integer> getAllFruits() {
        return new HashMap<>(fruitInventory);
    }
}
