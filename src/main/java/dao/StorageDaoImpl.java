package dao;

import db.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.storage.put(fruit, amount);
    }

    @Override
    public Integer getAmount(String fruit) {
        return Storage.storage.getOrDefault(fruit, 0);
    }

    @Override
    public void update(String fruit, Integer amount) {
        add(fruit, amount);
    }
}
