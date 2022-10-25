package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    private static final Storage STORAGE = new Storage();

    @Override
    public Integer getValue(String key) {
        return STORAGE.getFruits().get(key);
    }

    @Override
    public void putValue(String key, Integer value) {
        STORAGE.getFruits().put(key, value);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return STORAGE.getFruits().entrySet();
    }
}
