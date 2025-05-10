package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.NoSuchElementException;

public class StorageDaoImpl implements StorageDao {
    private final Storage storage = new Storage();

    @Override
    public void save(String fruit, int quantity) {
        if (fruit == null) {
            throw new RuntimeException("fruit cannot be null");
        }
        storage.getFruitStorage().put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getFruitStorage();
    }

    @Override
    public int getQuantityByFruitName(String key) {
        if (!storage.getFruitStorage().containsKey(key)) {
            throw new NoSuchElementException("No such key in storage: " + key);
        }
        return storage.getFruitStorage().get(key);
    }
}
