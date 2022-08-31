package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void set(Fruit fruitData, int quantity);

    void add(Fruit fruit, int quantity);

    void subtract(Fruit fruitData, int quantity);

    int get(Fruit fruitName);

    Map<Fruit, Integer> getAll();
}
