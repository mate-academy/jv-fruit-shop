package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public Map<String, Integer> getStorage() {
        return Storage.fruits;
    }

    @Override
    public void putProduct(String product, int quantity) {
        Storage.fruits.put(product, quantity);
    }

    @Override
    public int getAmountByProductName(String product) {
        return Storage.fruits.get(product);
    }
}
