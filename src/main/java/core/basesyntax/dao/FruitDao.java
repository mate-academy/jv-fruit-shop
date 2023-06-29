package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitDao {
    void add(Fruit fruit, int quantity);

    int getFruitQuantity(String fruitName);

    Map<Fruit, Integer> getAll();
}
