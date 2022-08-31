package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface FruitStorageDao {
    void update(String fruit, int quantity);

    Set<Map.Entry<String, Integer>> getEntries();
}
