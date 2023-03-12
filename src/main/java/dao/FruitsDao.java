package dao;

import java.util.Map;

public interface FruitsDao {

    void addFruit(String fruit, int quantity);

    int getQuantityByFruit(String fruit);

    Boolean contains(String fruit);

    Map<String, Integer> getAll();
}
