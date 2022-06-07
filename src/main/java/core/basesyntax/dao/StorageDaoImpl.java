package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateValues(String fruit, Integer quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer getRemainingFruits(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Map<String, Integer> extractData() {
        return Storage.storage;
    }
}
