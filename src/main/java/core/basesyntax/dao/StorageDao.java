package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void put(FruitTransaction transaction);
}
