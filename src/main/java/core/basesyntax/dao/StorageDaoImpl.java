package core.basesyntax.dao;

import java.util.Collections;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private final Map<String, Integer> fruits = core.basesyntax.db.Storage.fruits;

    @Override
    public Map<String, Integer> get() {
        return Collections.unmodifiableMap(fruits);
    }
}
