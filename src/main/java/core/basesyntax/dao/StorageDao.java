package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {

    void setFruitQuantity(String fruit, int quantity);

    void addFruitQuantity(String fruit, int quantity);

    void deductFruitQuantity(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    Map<String, Integer> getAllFruitsQuantities();
}
