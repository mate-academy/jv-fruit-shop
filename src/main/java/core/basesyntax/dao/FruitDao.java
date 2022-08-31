package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void put(Fruit fruitData);

    void subtract(Fruit fruitData);

    Fruit get(String fruitName);
}
