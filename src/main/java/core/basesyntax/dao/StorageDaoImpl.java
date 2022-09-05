package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void updateData(String fruit, Integer quantity) {
        Storage.getStorageMap().put(fruit, quantity);
    }

    @Override
    public Integer getRemainFruit(String fruit) {
        return Storage.getStorageMap().get(fruit);
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Storage.getStorageMap();
    }
}