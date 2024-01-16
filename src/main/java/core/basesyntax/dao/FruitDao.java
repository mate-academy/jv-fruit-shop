package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruitName, int quantity);

    Map<String, Integer> getAllFruits();
}
