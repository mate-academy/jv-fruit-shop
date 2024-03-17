package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void setBalance(String productType, int amount) {
        Storage.STORAGE_MAP.put(productType, amount);
    }

    @Override
    public void increaseAmount(String productType, int amount) {
        Storage.STORAGE_MAP.put(productType, getAmountByProduct(productType) + amount);
    }

    @Override
    public void decreaseAmount(String productType, int amount) {
        Storage.STORAGE_MAP.put(productType, getAmountByProduct(productType) - amount);
    }

    @Override
    public int getAmountByProduct(String product) {
        return Storage.STORAGE_MAP.get(product);
    }
}
