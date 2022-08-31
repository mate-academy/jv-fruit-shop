package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(String fruit, Integer amount);

    void supply(String fruit, Integer amount);

    void remove(String fruit, Integer amount);

    Set<Map.Entry<String, Integer>> getEntries();
}
