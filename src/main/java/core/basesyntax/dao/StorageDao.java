package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface StorageDao {
    default Map<String, Integer> getStorageState() {
        return Storage.storageMap;
    }

    void setBalance(String productType, int amount);
    void addAmount(String productType, int amount);
    void decreaseAmount(String productType, int amount);
    int getAmountByProduct(String product);
}
