package core.basesyntax.db.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void add(FruitTransaction fruitType);
    void remove(FruitTransaction fruitType);
}
