package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    void addProductCount(String productName, Integer count);

    Integer getProductCount(String productName);

    List<String> getProductInfo();

}
