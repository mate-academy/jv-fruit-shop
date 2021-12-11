package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Optional;

public interface FruitStorageDao {
    void add(Fruit fruit);

    Optional<Fruit> getFruit(String fruitName);

    void update(Fruit fruit);

    List<Fruit> getFruitList();
}
