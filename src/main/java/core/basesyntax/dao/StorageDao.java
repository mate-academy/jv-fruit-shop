package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Integer get(String fruit);

    void put(String fruit, Integer amount);

    Map<String, Integer> getAll();
}
