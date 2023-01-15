package core.basesyntax.dao;

import java.util.List;

import core.basesyntax.model.Fruit;

public interface FruitDao {
    void add(Fruit fruit);
    Integer getByName(Fruit fruit);
    List<Fruit> getFruitList();
}
