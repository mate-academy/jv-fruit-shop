package db;

import core.basesyntax.FruitInventory;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private Map<String, FruitInventory> inventoryDatabase;

    public DataBase() {
        this.inventoryDatabase = new HashMap<>();
    }

    public void addToDatabase(FruitInventory inventory) {
        String fruit = inventory.getFruit();
        inventoryDatabase.put(fruit, inventory);
    }

    public FruitInventory getFromDatabase(String fruit) {
        return inventoryDatabase.get(fruit);
    }

    public boolean containsFruit(String fruit) {
        return inventoryDatabase.containsKey(fruit);
    }

    public void removeFromDatabase(String fruit) {
        inventoryDatabase.remove(fruit);
    }

    public Map<String, FruitInventory> getAllInventories() {
        return inventoryDatabase;
    }
}
