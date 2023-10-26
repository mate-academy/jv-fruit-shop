package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    int get(String name);

    void add(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getAll();
}
