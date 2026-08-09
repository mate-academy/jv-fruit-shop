package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final HashMap<String, Integer> storage = new HashMap<>();

    public void setFruitQuantity(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }

    public int getQuantity(String fruit) {
        return storage.getOrDefault(fruit, 0);
    }

    public void addFruit(String fruit, int quantity) {
        storage.put(fruit, storage.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        int currentQuantity = getQuantity(fruit);

        if (currentQuantity < quantity) {
            throw new IllegalArgumentException("Not enough fruit in storage");
        }
        storage.put(fruit, currentQuantity - quantity);
    }

    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage);
    }
}
