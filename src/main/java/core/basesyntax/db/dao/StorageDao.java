package core.basesyntax.db.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void add(FruitTransaction fruitTransaction);
    FruitTransaction get(String type);
}
