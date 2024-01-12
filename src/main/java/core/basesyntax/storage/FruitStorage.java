package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage {
    private Map<String, Integer> fruitStorage;

    public FruitStorage() {
        this.fruitStorage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return fruitStorage;
    }

    public void addData(String fruit, Integer quantity) {
        fruitStorage.put(fruit, quantity);
    }

    public void editQuantity(String fruit, Integer quantity) {
        int anotherQuantity = fruitStorage.get(fruit) - quantity;
        fruitStorage.put(fruit, anotherQuantity);
    }

    public void addQuantity(String fruit, Integer quantity) {
        int anotherQuantity = fruitStorage.get(fruit) + quantity;
        fruitStorage.put(fruit, anotherQuantity);
    }

}
