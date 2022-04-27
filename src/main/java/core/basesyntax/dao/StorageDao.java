package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Integer get(String key);

    Map<String, Integer> getAll();

    void add(String key, Integer value);
}
