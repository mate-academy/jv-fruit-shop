package core.basesyntax.dao.storage.impl;

import core.basesyntax.dao.storage.StorageDao;
import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Map<String, Integer> getAll() {
        return Storage.storageMap;
    }

    @Override
    public int getQuantityByKey(String key) {
        return Storage.storageMap.get(key);
    }

    @Override
    public void put(String key, int value) {
        Storage.storageMap.put(key, value);
    }

    @Override
    public boolean checkIfExist(String key) {
        return Storage.storageMap.containsKey(key);
    }

    @Override
    public boolean isEnoughFruits(String fruit, int quantity) {
        return getQuantityByKey(fruit) >= quantity;
    }
}
