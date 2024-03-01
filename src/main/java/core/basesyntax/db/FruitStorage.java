package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitStorage {
    private static final Map<String, Integer> fruitInventory = new HashMap<>();

    public static void addFruit(String fruit, int quantity) {
        fruitInventory.merge(fruit, quantity, Integer::sum);
    }

    public static void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new RuntimeException("Quality cannot be less than current quality");
        }
        fruitInventory.put(fruit, currentQuantity - quantity);
    }

    public static Set<Map.Entry<String, Integer>> getFruitInventoryEntries() {
        return fruitInventory.entrySet();
    }
}
