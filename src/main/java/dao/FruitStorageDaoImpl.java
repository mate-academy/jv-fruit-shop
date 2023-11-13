package dao;

import db.Storage;
import java.util.Map;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void updateFruitQuantity(String fruit, int quantity) {
        Storage.STORAGE.put(fruit, quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return Storage.STORAGE.getOrDefault(fruit, 0);
    }

    @Override
    public Map<String, Integer> getAllFruit() {
        return Storage.STORAGE;
    }
}
