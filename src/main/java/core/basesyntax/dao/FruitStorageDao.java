package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitStorageDao {
    Integer getQuantity(Fruit fruit);

    Integer put(Fruit fruit, Integer quantity);
}
