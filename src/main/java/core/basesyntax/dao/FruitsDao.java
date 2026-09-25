package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {

    Map<String, Integer> getAll();

    void addFruitToStorage(String key, Integer value);

    Integer getFruitFromStorage(String fruitName);
}
