package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitStorageDao {
    Integer getValue(Fruit key);

    Integer put(Fruit key, Integer value);
}
