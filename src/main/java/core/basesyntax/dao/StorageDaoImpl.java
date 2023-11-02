package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.fruits.get(fruit);
    }

}
