package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void put(String fruit, Integer quantity);

    Integer get(String fruit);

    Map<String, Integer> getAll();
}
