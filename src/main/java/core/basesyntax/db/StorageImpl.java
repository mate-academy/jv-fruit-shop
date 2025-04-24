package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    public static final Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void updateFruitBalance(String fruit, int quantity) {
        int currentBalance = fruitStorage.getOrDefault(fruit,0);
        fruitStorage.put(fruit,currentBalance + quantity);
    }

    @Override
    public int getFruitBalance(String fruit) {
        return fruitStorage.getOrDefault(fruit,0);
    }

    @Override
    public void setFruitBalance(String fruit, int newBalance) {
        if (newBalance < 0) {
            throw new RuntimeException("Balance of fruits can't be negative " + newBalance);
        }
        fruitStorage.put(fruit,newBalance);
    }

    @Override
    public Map<String, Integer> getAll() {
        return new HashMap<>(fruitStorage);
    }

}
