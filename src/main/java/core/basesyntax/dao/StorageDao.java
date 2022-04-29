package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(Fruit fruit, int quantity);

    void supply(Fruit fruit, int quantity);

    void take(Fruit fruit, int quantity);

    boolean contains(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
