package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruitName, int quantity) {
        Storage.storage.put(fruitName, quantity);
    }

    @Override
    public void update(String fruitName, int quantity) {
        Storage.storage.put(fruitName, Storage.storage.get(fruitName) - quantity);
    }
}
