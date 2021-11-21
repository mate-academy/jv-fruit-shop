package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    Fruit get(String fruitName);

    void add(Fruit fruit);

    void update(Fruit fruit);
}
