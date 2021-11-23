package core.basesyntax.bd.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit, int amount);

    Fruit get(Fruit fruit);

    Integer getValue(Fruit fruit);
}
