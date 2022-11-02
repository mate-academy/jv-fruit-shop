package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    Fruit update(Fruit fruit, Integer amount);
}
