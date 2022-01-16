package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.Optional;

public interface FruitDao {
    public Optional<Fruit> get(String name);
    public void put(Fruit fruit);
}
