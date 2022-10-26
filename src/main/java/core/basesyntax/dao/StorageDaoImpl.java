package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class StorageDaoImpl implements StorageDao {
    private static final Map<String, Integer> FRUIT_MAP = new Storage().getFruits();

    @Override
    public Integer getValue(String key) {
        return FRUIT_MAP.get(key);
    }

    @Override
    public Integer putValue(String key, Integer value) {
        return FRUIT_MAP.put(key, value);
    }

    @Override
    public Set<Map.Entry<String, Integer>> getEntrySet() {
        return FRUIT_MAP.entrySet();
    }
}
