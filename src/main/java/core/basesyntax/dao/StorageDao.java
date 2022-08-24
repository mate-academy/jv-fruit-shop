package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    void saveAll(Map<String, Integer> fruitBalance);

    Map<String, Integer> getAll();
}
