package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit, Integer integer);

    Integer getInteger(Fruit fruit);
}
