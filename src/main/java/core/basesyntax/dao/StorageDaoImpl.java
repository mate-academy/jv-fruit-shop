package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Storage storage;

    public StorageDaoImpl() {
        storage = new Storage();
    }

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
        return storage.getFruitStorage().get(key);
    }
}
