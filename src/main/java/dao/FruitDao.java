package dao;

import java.util.Map;
import java.util.Optional;
import model.Fruit;

public interface FruitDao {
    void add(Fruit fruit, Integer amount);

    Optional<Integer> get(Fruit fruit);

    Map<Fruit, Integer> getDB();
}
