package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitStorageDao {

    void update(Fruit fruit, int quantity);

    int getQuantity(Fruit fruit);
}
