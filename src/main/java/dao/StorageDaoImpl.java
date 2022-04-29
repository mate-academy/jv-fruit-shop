package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }

    @Override
    public Integer get(Fruit fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.storage.entrySet();
    }
}
