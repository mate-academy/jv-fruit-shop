package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> getStorageState();

    void putToInventory(String productType, int amount);

    int getAmountByProduct(String product);
}
