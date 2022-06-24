package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Integer get(String fruit);

    void update(String name, Integer newAmount);

    Map<String, Integer> getAll();
}
