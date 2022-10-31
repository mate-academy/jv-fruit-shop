package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    int add(Fruit fruit, int quantity);

    int update(Fruit fruit, int quantity);

    int get(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
