package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruitName, Integer count) {
        Storage.fruitsCount.put(fruitName, count);
    }

    @Override
    public Map<String, Integer> getInfo() {
        return Storage.fruitsCount;
    }
}
