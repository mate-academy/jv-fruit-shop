package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    void add(Fruit fruit, Integer quantity);

    void remove(Fruit fruit, Integer quantity);
}
