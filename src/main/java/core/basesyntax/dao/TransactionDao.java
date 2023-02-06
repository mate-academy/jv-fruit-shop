package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface TransactionDao {
    void add (FruitTransaction fruitTransaction);
    FruitTransaction get();
}
