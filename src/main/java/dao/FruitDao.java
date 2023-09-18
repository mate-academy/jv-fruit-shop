package dao;

import java.util.Map;

public interface FruitDao {
    void add(String fruitName, Integer quantity);

    Integer get(String fruitName);

    Map<String, Integer> getAll();

}
