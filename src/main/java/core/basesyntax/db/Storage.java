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
        return new HashMap<>(fruitInventory);
    }

    public void updateFruitQuantity(FruitTransaction.Operation operation,
                                    String fruitName, int quantity) {
        int currentQuantity = fruitInventory.getOrDefault(fruitName, 0);
        switch (operation) {
            case BALANCE:
            case SUPPLY:
            case RETURN:
                currentQuantity += quantity;
                break;
            case PURCHASE:
                currentQuantity -= quantity;
                break;
            default:
                throw new IllegalArgumentException("Unknown operation type: " + operation);
        }
        if (currentQuantity < 0) {
            throw new IllegalArgumentException("Negative fruit quantity not allowed: " + fruitName);
        }

        fruitInventory.put(fruitName, currentQuantity);
    }
}
