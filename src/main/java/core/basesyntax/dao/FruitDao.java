package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruitName, int quantity);

    Integer get(String fruitName);

    Map<String, Integer> getAll();
}
