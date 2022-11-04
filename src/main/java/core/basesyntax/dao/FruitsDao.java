package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitsDao {
    void save(String fruitName, int amount);

    int get(String fruitName);

    Set<Map.Entry<String, Integer>> getAll();
}
