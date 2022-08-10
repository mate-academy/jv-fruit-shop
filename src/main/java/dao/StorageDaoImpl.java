package dao;

import db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateData(String fruit, Integer quantity) {
        Storage.storageMap.put(fruit, quantity);
    }

    @Override
    public Integer getRemainFruit(String fruit) {
        return Storage.storageMap.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storageMap;
    }
}
