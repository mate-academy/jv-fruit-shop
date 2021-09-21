package dao;

import java.util.Map;
import model.Fruit;

public interface FruitsDao {
    void add(Fruit operationFruit, int value);

    int get(Fruit operationFruit);

    Map<Fruit, Integer> getAll();
}
