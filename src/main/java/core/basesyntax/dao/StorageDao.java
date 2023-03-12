package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Set;

public interface StorageDao {
    void put(Fruit key, Integer value);

    Integer get(Fruit key);

    Set<Fruit> getAllKeys();
}
