package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String fruitName, int quantity);

    Integer get(String key);

    Map<String, Integer> getStorageState();
}
