package dao;

import java.util.Map;

public interface FruitsDao {
    int get(String fruit);

    boolean remove(String fruit);

    void add(String fruit, int amount);

    Map<String, Integer> getCurrentFruitAmount();
}
