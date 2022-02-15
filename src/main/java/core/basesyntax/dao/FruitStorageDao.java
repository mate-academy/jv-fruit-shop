package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitStorageDao {
    void add(Fruit fruit);

    Fruit get(String fruitName);

    List<Fruit> getAll();
}
