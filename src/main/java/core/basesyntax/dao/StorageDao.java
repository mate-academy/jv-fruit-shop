package core.basesyntax.dao;

import java.util.HashMap;

public interface StorageDao {
    void addToStorage(String key, Integer value);

    Integer getFromStorage(String key);

    HashMap<String, Integer> getAll();
}
