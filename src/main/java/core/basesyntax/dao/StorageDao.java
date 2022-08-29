package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void add(FruitTransaction fruit);

    Integer get(String fruit);
}
