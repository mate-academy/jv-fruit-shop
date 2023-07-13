package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void add(String fruit, int amount);

    void supply(String fruit, int amount);

    void remove(String fruit, int amount);

    Map<String, Integer> getAll();
}
