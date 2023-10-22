package db;

import core.basesyntax.FruitInventory;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private final Map<String, FruitInventory> inventoryDatabase;

    public DataBase() {
        this.inventoryDatabase = new HashMap<>();
    }

    public void updateInventory(String fruit, FruitInventory inventory) {
        inventoryDatabase.put(fruit, inventory);
    }

    public FruitInventory getOrCreateInventory() {
        return inventoryDatabase.computeIfAbsent("default", key -> new FruitInventory());
    }

    public FruitInventory getInventory(String fruit) {
        return inventoryDatabase.get(fruit);
    }

    public boolean containsFruit(String fruit) {
        return inventoryDatabase.containsKey(fruit);
    }

    public void removeInventory(String fruit) {
        inventoryDatabase.remove(fruit);
    }

    public Map<String, FruitInventory> getAllInventories() {
        return inventoryDatabase;
    }
}
