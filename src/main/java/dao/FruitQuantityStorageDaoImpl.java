package dao;

import db.Storage;

public class FruitQuantityStorageDaoImpl implements FruitQuantityStorageDao {
    @Override
    public void add(String fruitName, int fruitQuantity) {
        Storage.storage.put(fruitName,fruitQuantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.storage.get(fruitName);
    }
}
