package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Storage storage;

    public StorageDaoImpl() {
        storage = new Storage();
    }

    @Override
    public Map<String, Integer> save(String fruit, int quantity) {
        storage.getFruitStorage().put(fruit, quantity);
        return storage.getFruitStorage();
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getFruitStorage();
    }

    @Override
    public int getQuantity(String key) {
        return storage.getFruitStorage().get(key);
    }
}
