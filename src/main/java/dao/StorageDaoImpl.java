package dao;

import db.Storage;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public void update(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.storage.get(fruit);
    }
}
