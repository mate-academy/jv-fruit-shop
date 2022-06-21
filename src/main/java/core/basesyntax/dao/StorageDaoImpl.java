package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.HashMap;

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
    public HashMap<String, Integer> getAll() {
        return Storage.fruitsStore;
    }
}

