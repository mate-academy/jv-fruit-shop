package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    Map<String, Integer> getFruits();

    Integer getFruitQuantity(String fruitName);

    void updateFruitQuantity(String fruitName, Integer quantity);
}
