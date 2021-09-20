package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitsDao {
    void add(Fruit fruit);

    Fruit get(String someFruit);
}
