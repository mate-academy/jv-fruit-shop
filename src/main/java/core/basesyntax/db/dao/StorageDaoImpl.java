package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruitName, Long count) {
        Storage.fruitsCount.put(fruitName, count);
    }

    @Override
    public Map<String, Long> getInfo() {
        return Storage.fruitsCount;
    }
}
