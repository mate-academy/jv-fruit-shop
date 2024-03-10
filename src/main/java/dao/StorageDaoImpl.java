package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addFruitToStorage(String fruit, int amount) {
        Storage.STORAGE.put(fruit, amount);
    }

    @Override
    public int getAmount(String fruit) {
        return Storage.STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.STORAGE;
    }
}
