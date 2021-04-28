package dao;

import java.util.Map;
import model.Fruit;

public interface FruitDao {
    void put(Fruit.Type fruitType, Integer value);

    Integer get(Fruit.Type fruitType);

    Map<Fruit.Type, Integer> getAll();
}
