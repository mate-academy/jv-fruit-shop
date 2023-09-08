package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void add(Fruit fruit, Integer quantity);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
