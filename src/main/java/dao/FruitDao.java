package dao;

import java.util.Map;
import java.util.Set;
import model.FruitType;

public interface FruitDao {
    void put(FruitType fruitType, Integer count);

    Set<Map.Entry<FruitType, Integer>> getEntries();

    Map<FruitType, Integer> getMap();
}
