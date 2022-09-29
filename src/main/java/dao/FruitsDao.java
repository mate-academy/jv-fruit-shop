package dao;

import java.util.Map;

public interface FruitsDao {
    void addFruit(String Fruit, int quantity);
    int getQuantityByFruit(String fruit);
    Boolean contains(String Fruit);
    Map<String, Integer> getAll();
}
