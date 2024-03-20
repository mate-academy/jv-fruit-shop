package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    public Map<String, Integer> getStorageState() {
        return Storage.getStorageMap();
    }

    @Override
    public void putToInventory(String productType, int amount) {
        Storage.getStorageMap().put(productType, amount);
    }

    @Override
    public int getAmountByProduct(String product) {
        return Storage.getStorageMap().get(product);
    }
}
