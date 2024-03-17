package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public interface StorageDao {
    default Map<String, Integer> getStorageState() {
        return Storage.STORAGE_MAP;
    }

    void setBalance(String productType, int amount);

    void increaseAmount(String productType, int amount);

    void decreaseAmount(String productType, int amount);

    int getAmountByProduct(String product);
}
