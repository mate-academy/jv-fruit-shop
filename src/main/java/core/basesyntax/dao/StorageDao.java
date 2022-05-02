package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void compute(Fruit fruit, Integer quantity);

    Integer getValue(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
