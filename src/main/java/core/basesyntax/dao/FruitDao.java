package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void update(String fruit, int quantity);

    void add(String fruit, int quantity);

    void subtract(String fruit, int quantity);

    Map<String, Integer> getAllFruits();
}
