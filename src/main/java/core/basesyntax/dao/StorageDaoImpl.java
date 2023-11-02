package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, int quantity) {
        Storage.FRUITS.put(fruit, quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return Storage.FRUITS.get(fruit);
    }

}
