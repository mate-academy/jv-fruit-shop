package core.basesyntax.service;

import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> inventory;

    public InventoryService(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public void addFruit(String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough " + fruit + " in stock.");
        }
        inventory.put(fruit, currentQuantity - quantity);
    }

    public int getQuantity(String fruit) {
        return inventory.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getInventory() {
        return Map.copyOf(inventory);
    }
}
