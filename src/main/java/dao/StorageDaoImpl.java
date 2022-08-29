package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void update(String fruit, Integer quantity) {
        Storage.storageList.put(fruit, quantity);
    }

    @Override
    public int remainder(String fruit) {
        return Storage.storageList.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storageList;
    }
}
