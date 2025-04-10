package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static final Map<String, Integer> fruitStorage = new HashMap<>();

    private static final Storage instance = new Storage();

    private Storage() {

    }

    public static Storage getInstance() {
        return instance;
    }

    public void updateFruitBalance(String fruit, int quantity) {
        int currentBalance = fruitStorage.getOrDefault(fruit, 0);
        int newBalance = currentBalance + quantity;
        fruitStorage.put(fruit, newBalance);
    }

    public int getFruitBalance(String fruit) {
        return fruitStorage.getOrDefault(fruit, 0);
    }

    public void setFruitBalance(String fruit, int newBalance) {
        fruitStorage.put(fruit, newBalance);
    }

    public Map<String, Integer> getAll() {
        return new HashMap<>(fruitStorage);
    }
}
