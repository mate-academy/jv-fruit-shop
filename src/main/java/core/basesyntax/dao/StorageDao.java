package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void update(String fruit, Integer quantity);

    Integer getCurrentFruits(String fruit);

    Map<String, Integer> getData();
}