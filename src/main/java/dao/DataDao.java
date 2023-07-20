package dao;

import java.util.Map;

public interface DataDao {
    void putValue(String key, Integer value);

    Integer getValue(String key);

    Map<String, Integer> getFruitMap();
}
