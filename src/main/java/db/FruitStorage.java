package db;

import java.util.HashMap;
import java.util.Set;

public class FruitStorage implements Storage {

    private static final int DEFAULT_QUANTITY = 0;

    private HashMap<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void addFruitInQuantity(String fruitName, Integer quantity) {
        fruitStorage.put(fruitName,
                fruitStorage.getOrDefault(fruitName, DEFAULT_QUANTITY) + quantity);
    }

    @Override
    public void removeFruitInQuantity(String fruitName, Integer quantity) {
        fruitStorage.put(fruitName,
                fruitStorage.getOrDefault(fruitName, DEFAULT_QUANTITY) - quantity);
    }

    @Override
    public int getQuantity(String fruitName) {
        return fruitStorage.getOrDefault(fruitName, DEFAULT_QUANTITY);
    }

    @Override
    public Set<String> getAllItems() {
        return fruitStorage.keySet();
    }
}
