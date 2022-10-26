package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void set(String fruitName, Integer quantity) {
        Storage.storage.put(fruitName, quantity);
    }

    @Override
    public Integer get(String fruitName) {
        if (!Storage.storage.containsKey(fruitName)) {
            throw new RuntimeException("There is no " + fruitName + " in the storage");
        }
        return Storage.storage.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.storage;
    }
}
