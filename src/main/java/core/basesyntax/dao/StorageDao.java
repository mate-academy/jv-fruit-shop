package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void updateValues(String fruit, Integer quantity);

    Integer getRemainingFruits(String fruit);

    Set<Map.Entry<String, Integer>> extractData();
}
