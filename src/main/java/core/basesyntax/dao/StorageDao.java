package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void add(String fruit, Integer quantity);

    Map<String,Integer> getAll();
}
