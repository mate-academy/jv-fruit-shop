package core.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruitName, int fruitCount);

    int get(String fruitName);

    Map<String,Integer> getAll();
}
