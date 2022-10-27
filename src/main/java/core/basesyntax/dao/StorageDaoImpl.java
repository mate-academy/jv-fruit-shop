package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Integer getValue(String key) {
        return Storage.fruits.get(key);
    }

    @Override
    public Integer putValue(String key, Integer value) {
        return Storage.fruits.put(key, value);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return Storage.fruits.entrySet();
    }
}
