package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void addFruit(String fruit, int quantity);

    void subtractFruit(String fruit, int quantity);

    Map<String, Integer> getAllFruits();
}
