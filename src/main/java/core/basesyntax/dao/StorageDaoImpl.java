package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addToStorage(String key, Integer value) {
        Storage.storage.put(key, value);
    }

    @Override
    public Integer getFromStorage(String key) {
        return Storage.storage.get(key);
    }

    @Override
    public HashMap<String, Integer> getAll() {
        return Storage.storage;
    }
}
