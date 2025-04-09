package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, Integer> fruitStorage = new HashMap<>();

    public void updateFruitBalance(String fruit, int quantity) {
        int currentBalance = fruitStorage.getOrDefault(fruit, 0);
        int newBalance = currentBalance + quantity;
        fruitStorage.put(fruit, newBalance);
    }

    public int getFruitBalance(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getFruitTransactionInfo() {
        return new HashMap<>(fruitStorage);
    }

    public void setFruitBalance(String fruit, int newBalance) {
        fruitStorage.put(fruit, newBalance);
    }
}
