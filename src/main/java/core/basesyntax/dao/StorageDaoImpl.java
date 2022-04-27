package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Integer get(String key) {
        return Storage.dataBase.get(key);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.dataBase;
    }

    @Override
    public void add(String key, Integer value) {
        Storage.dataBase.put(key, value);
    }
}
