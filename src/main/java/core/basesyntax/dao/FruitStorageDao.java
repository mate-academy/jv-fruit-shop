package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    void updateFruitQuantity(String fruit, Integer quantity);

    Integer getFruitQuantity(String fruit);

    Map<String, Integer> getAllFruit();
}
