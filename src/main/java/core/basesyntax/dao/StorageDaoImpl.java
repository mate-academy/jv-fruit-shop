package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void create(String fruit, Integer quantity) {
        Storage.fruitsStore.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruitsStore.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitsStore;
    }
}

