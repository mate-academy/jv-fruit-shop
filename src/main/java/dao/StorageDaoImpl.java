package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    private Storage storage;

    public StorageDaoImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void update(String fruitName, Integer amount) {
        Storage.storage.put(fruitName, amount);
    }

    @Override
    public Integer getFruitQuantity(String fruit) {
        return Storage.storage.get(fruit);
    }

    @Override
    public Map<String, Integer> getAll() {
        return storage.getStorage();
    }
}
