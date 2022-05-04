package dao;

import java.util.Map;

public interface DatabaseDao {

    void addFruit(String fruit, Integer quantity);

    Map<String, Integer> getAllFruits();
}
