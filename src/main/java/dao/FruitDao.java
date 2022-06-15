package dao;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void add(String fruit, Integer count);

    Integer get(String fruit);

    Set<Map.Entry<String, Integer>> getAll();
}
