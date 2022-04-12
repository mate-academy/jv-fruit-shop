package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void update(Fruit fruit, Integer quantity);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
