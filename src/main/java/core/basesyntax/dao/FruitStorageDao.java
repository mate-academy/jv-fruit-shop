package core.basesyntax.dao;

import core.basesyntax.model.Fruit;

public interface FruitStorageDao {
    void addNewFruitToStorage(Fruit fruit);

    Fruit get(String fruitName);

    void update(Fruit fruit, int quantity);
}
