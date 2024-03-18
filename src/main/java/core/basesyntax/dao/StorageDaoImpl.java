package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    public Map<String, Integer> getStorageState() {
        return Storage.STORAGE_MAP;
    }

    @Override
    public void putToInventory(String productType, int amount) {
        Storage.STORAGE_MAP.put(productType, amount);
    }

    @Override
    public int getAmountByProduct(String product) {
        return Storage.STORAGE_MAP.get(product);
    }
}
