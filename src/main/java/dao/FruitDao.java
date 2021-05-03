package dao;

import java.util.Map;
import model.Fruit;

public interface FruitDao {
    void add(Fruit fruit, Integer amount);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getDB();
}
