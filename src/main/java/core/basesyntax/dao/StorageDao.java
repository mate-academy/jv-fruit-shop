package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(Fruit fruit, int quantity);

    void supply(Fruit fruit, int quantity);

    void subtract(Fruit fruit, int quantity);

    int getValue(Fruit fruit);

    boolean containsKey(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
