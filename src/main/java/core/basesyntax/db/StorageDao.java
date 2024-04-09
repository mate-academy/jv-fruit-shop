package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;

public interface StorageDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);
}
