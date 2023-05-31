package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void set(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        if (fruitName != null) {
            throw new RuntimeException("Null ++");
        }
        return Storage.fruitStorage.get(fruitName);
    }
}
