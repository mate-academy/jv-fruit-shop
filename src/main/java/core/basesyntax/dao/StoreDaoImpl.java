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
    public void add(String key, Integer value) {
        storage.getStorageFruits().put(key, value);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return new HashMap<>(storage.getStorageFruits());
    }

    @Override
    public void clean() {
        storage.getStorageFruits().clear();
    }
}
