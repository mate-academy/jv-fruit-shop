package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(String name, int quantity);

    int get(String fruitName);

    boolean contains(String fruitName);

    Set<Map.Entry<String, Integer>> getAll();
}
