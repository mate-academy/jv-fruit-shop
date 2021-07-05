package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface FruitDao {
    void put(Fruit fruit, int fruitQuantity);

    Integer getQuantity(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getSet();
}
