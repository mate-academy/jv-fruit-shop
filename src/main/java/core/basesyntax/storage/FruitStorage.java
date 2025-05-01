package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitStorage implements Storage {
    public static final Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void saveItem(String fruit, int quantity) {
        fruitStorage.put(fruit, quantity);
    }

    @Override
    public void supplyItem(String fruit, int quantity) {
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public void purchaseItem(String fruit, int quantity) {
        fruitStorage.put(fruit, fruitStorage.getOrDefault(fruit, 0) - quantity);
    }

    @Override
    public int getAmount(String item) {
        return fruitStorage.get(item);
    }
}
