package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void save(String fruit, int quantity);

    Map<String, Integer> getAll();

    int getQuantityByFruitName(String key);
}
