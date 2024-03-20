package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Map<String, Integer> getStorage();

    void putProduct(String product, int quantity);

    int getAmountByProductName(String product);
}
