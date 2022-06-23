package dao;

import java.util.Map;

public interface FruitsDao {
    int get(String fruit);

    boolean add(String fruit, int amount);

    Map<String, Integer> getCurrentFruitAmount();
}
