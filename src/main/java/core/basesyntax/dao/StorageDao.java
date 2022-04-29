package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(Fruit fruit, Integer quantity);

    void remove(Fruit fruit, Integer quantity);

    int getFruitQuantity(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
