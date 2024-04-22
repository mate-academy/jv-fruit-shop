package dao;

import model.Fruit;

import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void add(Fruit fruit, Integer value);
    void put(Fruit fruit, Integer count);
    Integer get(Fruit fruit);
    Map<Fruit, Integer> getMap();
    Set<Map.Entry<Fruit, Integer>> getEntries();
}
