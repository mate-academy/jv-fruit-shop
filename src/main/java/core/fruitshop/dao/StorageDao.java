package core.fruitshop.dao;

import java.util.Map;

public interface StorageDao {
    void addProduct(String productName, int amount);

    int getAmount(String productName);

    void setAmount(String productName, int amount);

    boolean contains(String productName);

    Map<String, Integer> dumpData();
}
