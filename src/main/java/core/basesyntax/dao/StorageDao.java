package core.basesyntax.dao;

import java.util.HashMap;

public interface StorageDao {
    void create(String key, Integer value);

    Integer get(String key);

    HashMap<String, Integer> getAll();
}
