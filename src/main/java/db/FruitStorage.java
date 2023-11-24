package db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitStorage {
    private Map<String, Integer> fruitInventory;

    public FruitStorage() {
        fruitInventory = new HashMap<>();
    }

    public FruitStorage(Map<String, Integer> fruitInventory) {
        this.fruitInventory = fruitInventory;
    }

    public Set<Map.Entry<String, Integer>> getAllFruitEntries() {
        return fruitInventory.entrySet();
    }

    public int getQuantity(String fruit) {
        return fruitInventory.getOrDefault(fruit, 0);
    }

    public void addQuantity(String fruit, int quantity) {
        fruitInventory.merge(fruit, quantity, Integer::sum);
    }

    public void subtractQuantity(String fruit, int quantity) {
        fruitInventory.merge(fruit, -quantity, Integer::sum);
    }
}
