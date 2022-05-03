package core.basesyntax.db;

import core.basesyntax.models.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(Fruit fruit, Integer quantity);

    Integer get(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
