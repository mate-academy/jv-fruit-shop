package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<String, Integer> fruitInventory;

    private Storage() {
        this.fruitInventory = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, Integer> getFruitInventory() {
        return new HashMap<>(fruitInventory); // Return a copy to prevent external modifications
    }

    public void updateFruitQuantity(FruitTransaction.Operation operation, String fruitName, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruitName, 0);
        switch (operation) {
            case BALANCE, SUPPLY, RETURN -> currentQuantity += quantity;
            case PURCHASE -> currentQuantity -= quantity;
            default -> throw new IllegalArgumentException("Unknown operation type: " + operation);
        }
        if (currentQuantity < 0) {
            throw new IllegalArgumentException("Negative fruit quantity not allowed: " + fruitName);
        }
        fruitInventory.put(fruitName, currentQuantity);
    }
}
