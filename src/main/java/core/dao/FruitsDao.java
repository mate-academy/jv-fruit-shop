package core.dao;

import java.util.Map;

public interface FruitsDao {
    void add(String fruit, int amount);

    int get(String fruit);

    Map<String, Integer> getAll();
}
