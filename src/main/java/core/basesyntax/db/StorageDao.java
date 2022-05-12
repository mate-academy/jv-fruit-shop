package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void add(Fruit fruit, int amount);

    Map<Fruit, Integer> getAll();
}
