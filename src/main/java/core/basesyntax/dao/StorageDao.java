package core.basesyntax.dao;

import java.util.Map;

public interface StorageDao {
    Integer getByKey(String key);

    Map<String, Integer> getDataBase();

    void addToDataBase(String key, Integer value);
}
