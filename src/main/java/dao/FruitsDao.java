package dao;

import java.util.Map;
import model.Fruit;

public interface FruitsDao {
    void save(Fruit operationFruit, int value);

    int get(Fruit operationFruit);

    Map<Fruit, Integer> getAll();
}
