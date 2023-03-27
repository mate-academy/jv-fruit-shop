package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    Fruit add(Fruit fruit, int quantity);

    Integer getQuantity(Fruit fruit);

    int size();

}
