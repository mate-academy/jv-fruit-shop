package dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void put(String string, Integer count);

    Set<Map.Entry<String, Integer>> getEntries();
}
