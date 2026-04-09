package dao.impl;

import java.util.Map;

public interface FruitDao {
    void add(String fruit, int quantity);

    void remove(String fruit, int quantity);

    int getQuantity(String fruit);

    Map<String, Integer> getAll();
}
