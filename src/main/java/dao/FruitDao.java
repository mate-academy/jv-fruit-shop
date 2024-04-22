package dao;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public interface FruitDao {
    void add(Fruit fruit, Integer value);

    void put(Fruit fruit, Integer count);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getMap();

    Set<Map.Entry<Fruit, Integer>> getEntries();
}
