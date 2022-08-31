package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void addToStorage(Fruit fruit);

    Fruit getFruit(String name);
}
