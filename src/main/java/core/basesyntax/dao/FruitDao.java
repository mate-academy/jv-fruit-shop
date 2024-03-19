package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    Map<String, Integer> getFruits();

    void addFruit(String fruitName, int quantity);

    int getFruitQuantity(String fruitName);
}
