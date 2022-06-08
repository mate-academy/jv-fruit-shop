package core.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruitName, int quantity);

    int get(String fruitName);

    Map<String,Integer> getAll();
}
