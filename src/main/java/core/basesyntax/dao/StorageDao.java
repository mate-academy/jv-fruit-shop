package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void create(String fruit, Integer quantity);

    Integer get(String fruit);

    Map<String, Integer> getAll();
}
