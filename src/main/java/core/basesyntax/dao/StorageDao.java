package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(String name, Integer quantity);

    Integer get(String name);

    Set<Map.Entry<String, Integer>> getAll();
}
