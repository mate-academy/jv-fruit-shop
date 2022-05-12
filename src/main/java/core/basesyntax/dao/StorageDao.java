package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void update(Fruit fruit, int quantity);

    Set<Map.Entry<Fruit, Integer>> getAll();

    Integer get(Fruit fruit);
}
