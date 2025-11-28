package core.basesyntax.db.impl;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    private final Map<String, Integer> fruitStore = new HashMap<>();

    @Override
    public int get(String fruitName) {
        return fruitStore.getOrDefault(fruitName, 0);
    }

    @Override
    public void put(String fruitName, int quantity) {
        fruitStore.put(fruitName, quantity);
    }

    @Override
    public Map<String, Integer> getFruitStore() {
        return new HashMap<>(fruitStore);
    }
}
