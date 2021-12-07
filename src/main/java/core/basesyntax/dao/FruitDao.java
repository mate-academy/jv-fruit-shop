package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void put(Fruit fruit, int fruitQuantity);

    Integer get(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
