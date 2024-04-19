package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitStorageImpl implements FruitStorage {
    private Map<String, Integer> fruitStorage = new HashMap<>();

    @Override
    public void add(String fruitName, Integer quantity) {
        fruitStorage.put(fruitName, quantity);
    }

    @Override
    public Integer getQuantity(String fruitName) {
        return fruitStorage.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return fruitStorage;
    }
}
