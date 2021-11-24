package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface FruitStorageDao {
    boolean add(Fruit fruit, int quantity);

    boolean contains(Fruit fruit);

    Integer getQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
