package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void add(String fruitName, int amount);

    Integer get(String fruitName);

    void remove(String fruitName, int amount);

    Map<Fruit, Integer> getAll();

    void addFirst(String fruitName, int amount);
}
