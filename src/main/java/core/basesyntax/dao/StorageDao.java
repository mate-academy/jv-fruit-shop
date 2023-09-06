package core.basesyntax.dao;

import java.util.List;

public interface StorageDao {
    void putFruit(String key, Integer value);

    List<String> getAllFruits();

    Integer getFruitAmount(String fruitName);
}
