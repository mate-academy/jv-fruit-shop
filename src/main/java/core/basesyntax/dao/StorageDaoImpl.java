package core.basesyntax.dao;

import core.basesyntax.db.Storage;

import java.util.Map;

public class StorageDaoImpl implements StorageDao{
    @Override
    public void add(String fruitName, Integer amount) {
        Storage.fruitStorageMap.put(fruitName, amount);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruitStorageMap.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitStorageMap;
    }
}
