package core.basesyntax.db.dao;

import core.basesyntax.db.Storage;

import java.util.Map;

public class StorageDaoImpl implements StorageDao{

    @Override
    public void set(String fruitName, int fruitQuantity) {
        Storage.fruitMap.put(fruitName,fruitQuantity);
    }

    @Override
    public Integer get(String fruitName) {
        return Storage.fruitMap.get(fruitName);
    }

    @Override
    public Map<String, Integer> getAll() {
        return Storage.fruitMap;
    }
}
