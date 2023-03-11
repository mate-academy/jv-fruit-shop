package core.basesyntax.bd.dao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    boolean add(Fruit fruit, Integer quantity);

    boolean isFruitPresent(Fruit fruit);

    Integer getFruitQuantity(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
