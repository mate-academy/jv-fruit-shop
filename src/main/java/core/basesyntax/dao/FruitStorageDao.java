package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface FruitStorageDao {
    boolean add(Fruit fruit);
    Fruit get(String fruitName);
    List<Fruit> getAll();
}
