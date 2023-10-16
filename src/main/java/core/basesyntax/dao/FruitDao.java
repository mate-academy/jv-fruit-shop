package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void add(String fruit, Integer amount);

    Integer get(String fruit);

    Map<String, Integer> getAll();
}
