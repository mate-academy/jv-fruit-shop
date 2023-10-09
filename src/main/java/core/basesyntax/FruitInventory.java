package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class FruitInventory {
    private Map<String, Integer> inventory;

    public FruitInventory() {
        this.inventory = new HashMap<>();
    }

    public void setInventory(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }

    public void addToInventory(String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        inventory.put(fruit, currentQuantity + quantity);
    }

    public void removeFromInventory(String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity >= quantity) {
            inventory.put(fruit, currentQuantity - quantity);
        } else {
            throw new IllegalArgumentException("Not enough " + fruit
                    + " in inventory for purchase");
        }
    }
}
