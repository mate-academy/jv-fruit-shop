package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void save(Fruit fruit, Integer amount);

    Integer get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
