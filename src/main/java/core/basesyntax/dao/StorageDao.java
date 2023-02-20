package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface StorageDao {
    int getQuantity(Fruit fruit);

    void add(Fruit fruit, int quantity);
}
