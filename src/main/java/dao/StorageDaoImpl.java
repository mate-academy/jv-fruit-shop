package dao;

import db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void set(String fruit, int quantity) {
        Storage.fruitStorage.put(fruit, quantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.fruitStorage.get(fruitName);
    }
}
