package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Storage instance;
    private final Map<String, FruitTransaction> fruitInventory;

    public Storage() {
        this.fruitInventory = new HashMap<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public Map<String, FruitTransaction> getFruitInventory() {
        return fruitInventory;
    }

    public void updateFruitQuantity(FruitTransaction.Operation operation,
                                    String fruitName, int quantity) {
        FruitTransaction fruit = fruitInventory.get(fruitName);
        if (fruit != null) {
            fruit.setQuantity(quantity);
        } else {
            fruitInventory.put(fruitName, new FruitTransaction(quantity));
        }
    }
}
