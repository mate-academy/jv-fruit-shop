package core.basesyntax.dao;

import java.util.Map;
import java.util.Set;

public interface StorageDao {
    Integer getValue(String key);

    Integer putValue(String key, Integer value);

    Set<Map.Entry<String, Integer>> getEntrySet();
}
