package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void addFruit(String fruit, int quantity);

    int getFruitQuantity(String fruitName);

    Map<String, Integer> getAllFruits();
}
