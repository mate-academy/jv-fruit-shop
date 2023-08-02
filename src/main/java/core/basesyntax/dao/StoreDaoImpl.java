package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;
import java.util.Map;

public class StoreDaoImpl implements StoreDao {
    private Storage storage;

    public StoreDaoImpl() {
        this.storage = new Storage();
    }

    @Override
    public boolean add(String key, Integer value) {
        storage.getStorageFruits().put(key, value);
        return true;
    }

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage.getStorageFruits());
    }

    @Override
    public boolean clean() {
        storage.getStorageFruits().clear();
        return storage.getStorageFruits().isEmpty();
    }
}
