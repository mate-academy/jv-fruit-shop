package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void addFruit(String key, Integer value);

    Integer getFruitBalance(String key);

    void update(String key, int value);

    Map<String, Integer> getFruitStorage();
}
