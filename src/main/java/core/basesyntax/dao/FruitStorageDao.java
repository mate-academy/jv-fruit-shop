package core.basesyntax.dao;

import java.util.Map;

public interface FruitStorageDao {
    void add(String fruitName, int quantity);

    int get(String key);

    Map<String, Integer> getStorageState();
}
