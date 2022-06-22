package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {

    @Override
    public Integer getFruitsQuantity(String fruit) {
        return Storage.storageMap.get(fruit);
    }

    @Override
    public void putNewValues(String fruit, Integer quantity) {
        Storage.storageMap.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getData() {
        return Storage.storageMap;
    }
}
