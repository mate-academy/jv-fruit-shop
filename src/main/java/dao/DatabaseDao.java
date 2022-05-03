package dao;

import java.util.Map;

public interface DatabaseDao {
    void addAllFruits(Map<String, Integer> fruitList);

    Map<String, Integer> getFruitTransaction();
}
