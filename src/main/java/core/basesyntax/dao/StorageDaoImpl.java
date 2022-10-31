package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateData(String fruit, Integer quantity) {
        Storage.storageMap.put(fruit, quantity);
    }

    @Override
    public Integer getFruitBalance(String fruit) {
        return Storage.storageMap.get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.storageMap;
    }
}
