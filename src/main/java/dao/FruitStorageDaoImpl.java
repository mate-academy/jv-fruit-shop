package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;

public class FruitStorageDaoImpl implements FruitStorageDao {
    @Override
    public void add(String fruitName, int fruitQuantity) {
        Storage.storage.put(fruitName,fruitQuantity);
    }

    @Override
    public int get(String fruitName) {
        return Storage.storage.get(fruitName);
    }

    @Override
    public List<String> getAllFruitsNames() {
        return new ArrayList<>(Storage.storage.keySet());
    }
}
