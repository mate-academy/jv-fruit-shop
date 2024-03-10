package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface IFruitDao {
    void add(Fruit fruit);

    void update(Fruit fruit);

    Fruit get(String name);

    boolean isFruitExist(String name);

    Fruit getByIndex(int index);

    int getSize();
}
