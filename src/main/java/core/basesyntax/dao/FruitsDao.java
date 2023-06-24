package core.basesyntax.dao;

import java.util.Map;

public interface FruitsDao {
    void addFruit(String fruit, int quantity);

    Map<String, Integer> getAllFruits();
}
