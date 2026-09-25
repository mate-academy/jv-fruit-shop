package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.Map;

public class FruitsDaoImpl implements FruitsDao {
    private final Storage storage;

    public FruitsDaoImpl() {
        this.storage = new Storage();
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getStorage();
    }

    @Override
    public void addFruitToStorage(String key, Integer value) {
        storage.addToStorage(key,value);
    }

    @Override
    public Integer getFruitFromStorage(String fruitName) {
        return storage.getFromStorage(fruitName);
    }
}
