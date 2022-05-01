package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {
    void add(Fruit fruit, int quantity);

    void update(Fruit fruit, int quantity);

    Integer getAmount(Fruit fruit);

    Set<Map.Entry<Fruit, Integer>> getAll();
}
