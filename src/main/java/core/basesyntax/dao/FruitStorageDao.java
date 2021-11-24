package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStorageDao {
    Fruit add(Fruit fruit, Integer quantity);

    boolean contains(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
