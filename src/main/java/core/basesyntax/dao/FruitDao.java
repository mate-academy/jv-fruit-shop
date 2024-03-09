package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);

    Fruit get(String fruit);

    void update(Fruit fruit);
}
