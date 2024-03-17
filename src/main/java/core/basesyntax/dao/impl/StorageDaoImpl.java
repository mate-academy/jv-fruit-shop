package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    Map<String, Integer> storageMap = Storage.storageMap;

    @Override
    public void setBalance(String productType, int amount) {
        storageMap.put(productType, amount);
    }

    @Override
    public void addAmount(String productType, int amount) {
        storageMap.put(productType, getAmountByProduct(productType) + amount);
    }

    @Override
    public void decreaseAmount(String productType, int amount) {
        storageMap.put(productType, getAmountByProduct(productType) - amount);
    }

    @Override
    public int getAmountByProduct(String product) {
        return storageMap.get(product);
    }

}
