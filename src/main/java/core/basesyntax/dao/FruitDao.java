package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getAll();

    Integer getQuantity(String fruitType);

    void add(String fruitType, int quantity);
}
