package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void set(String fruit, Integer quantity);

    void add(String fruit, Integer quantity);

    void remove(String fruit, Integer quantity);

    Map<String, Integer> getFruits();
}
