package core.basesyntax.dao;

import static core.basesyntax.db.Storage.fruits;

import java.util.Collections;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Map<String, Integer> get() {
        return Collections.unmodifiableMap(fruits);
    }
}
