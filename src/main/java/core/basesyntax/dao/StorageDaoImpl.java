package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
    }
}
