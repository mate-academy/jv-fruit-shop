package dao;

import java.util.Map;
import model.Fruit;

public interface FruitDao {
    void put(Fruit fruitType, Integer value);

    Integer get(Fruit fruitType);

    Map<Fruit, Integer> getAll();
}
