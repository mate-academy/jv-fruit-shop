package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void updateValues(String fruit, Integer quantity);

    Integer getRemainingFruits(String fruit);

    Map<String, Integer> extractData();
}
