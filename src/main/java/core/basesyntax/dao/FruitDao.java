package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void put(String fruitName, int quantity);

    int getByName(String fruitName);

    Map<String,Integer> getAll();
}
