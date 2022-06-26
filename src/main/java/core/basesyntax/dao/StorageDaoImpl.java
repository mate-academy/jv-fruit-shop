package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void update(String fruit, Integer quantity) {
        if (fruit == null || quantity == null) {
            throw new RuntimeException("You can't put null value to storage");
        }
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer getCurrentFruits(String fruit) {
        return Storage.storage.get(fruit) == null ? 0 : Storage.storage.get(fruit);
    }

    @Override
    public Map<String, Integer> getData() {
        if (Storage.storage.isEmpty()) {
            throw new RuntimeException("Storage is empty");
        }
        return Storage.storage;
    }
}