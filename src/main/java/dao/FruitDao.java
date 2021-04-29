package dao;

import java.util.Map;
import java.util.Optional;
import model.Fruit;

public interface FruitDao {
    void put(Fruit fruitType, Integer value);

    Optional<Integer> get(Fruit fruitType);

    Map<Fruit, Integer> getAll();
}
